/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.gcloud.datastore.BlobValue.of;
import static com.google.gcloud.datastore.BooleanValue.of;
import static com.google.gcloud.datastore.DateTimeValue.of;
import static com.google.gcloud.datastore.DoubleValue.of;
import static com.google.gcloud.datastore.KeyValue.of;
import static com.google.gcloud.datastore.LongValue.of;
import static com.google.gcloud.datastore.StringValue.of;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * An implementation of a Google Cloud Datastore Query that can be constructed by providing
 * all the specific query elements.
 *
 * <h3>A usage example:</h3>
 *
 * <p>A simple query that returns all entities for a specific kind
 * <pre>{@code
 *   Query<Entity> query = Query.entityQueryBuilder().kind(kind).build();
 *   QueryResults<Entity> results = datastore.run(query);
 *   while (results.hasNext()) {
 *     Entity entity = results.next();
 *     ...
 *   }
 * } </pre>
 *
 * <p>A simple key-only query of all entities for a specific kind
 * <pre>{@code
 *   Query<Key> keyOnlyQuery =  Query.keyQueryBuilder().kind(KIND1).build();
 *   QueryResults<Key> results = datastore.run(keyOnlyQuery);
 *   ...
 * } </pre>
 *
 * <p>A less trivial example of a projection query that returns the first 10 results
 * of "age" and "name" properties (sorted and grouped by "age") with an age greater than 18
 * <pre>{@code
 *   Query<ProjectionEntity> query = Query.projectionEntityQueryBuilder()
 *       .kind(kind)
 *       .projection(Projection.property("age"), Projection.first("name"))
 *       .filter(PropertyFilter.gt("age", 18))
 *       .distinctOn("age")
 *       .orderBy(OrderBy.asc("age"))
 *       .limit(10)
 *       .build();
 *   QueryResults<ProjectionEntity> results = datastore.run(query);
 *   ...
 * } </pre>
 *
 * @param <V> the type of the result values this query will produce
 * @see <a href="https://cloud.google.com/appengine/docs/java/datastore/queries">Datastore
 *     queries</a>
 */
public class StructuredQuery<V> extends Query<V> {

  private static final long serialVersionUID = 546838955624019594L;
  private static final String KEY_PROPERTY_NAME = "__key__";

  private final transient String kind;
  private final ImmutableList<String> projection;
  private final transient Filter filter;
  private final ImmutableList<String> distinctOn;
  private final transient ImmutableList<OrderBy> orderBy;
  private final transient Cursor startCursor;
  private final transient Cursor endCursor;
  private final transient int offset;
  private final transient Integer limit;

  public abstract static class Filter implements Serializable {

    private static final long serialVersionUID = -6443285436239990860L;

    Filter() {
    }

    protected abstract com.google.datastore.v1beta3.Filter toPb();

    static Filter fromPb(com.google.datastore.v1beta3.Filter filterPb) {
      switch (filterPb.getFilterTypeCase()) {
        case COMPOSITE_FILTER:
          return CompositeFilter.fromPb(filterPb.getCompositeFilter());
        case PROPERTY_FILTER:
          return PropertyFilter.fromPb(filterPb.getPropertyFilter());
        default:
          throw new AssertionError("Unexpected enum value " + filterPb.getFilterTypeCase());
      }
    }
  }

  /**
   * A class representing a filter composed of a combination of other filters.
   */
  public static final class CompositeFilter extends Filter {

    private static final long serialVersionUID = 3610352685739360009L;
    private final Operator operator;
    private final ImmutableList<Filter> filters;

    enum Operator {
      AND;

      com.google.datastore.v1beta3.CompositeFilter.Operator toPb() {
        return com.google.datastore.v1beta3.CompositeFilter.Operator.valueOf(name());
      }

      static Operator fromPb(com.google.datastore.v1beta3.CompositeFilter.Operator operatorPb) {
        return valueOf(operatorPb.name());
      }
    }

    private CompositeFilter(Operator operator, Filter first, Filter... other) {
      this.operator = operator;
      this.filters =
          ImmutableList.<Filter>builder().add(first).addAll(Arrays.asList(other)).build();
    }

    private CompositeFilter(Operator operator, ImmutableList<Filter> filters) {
      this.operator = operator;
      this.filters = filters;
      Preconditions.checkArgument(!filters.isEmpty(), "filters list must not be empty");
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("operator", operator);
      toStringHelper.add("filters", filters);
      return toStringHelper.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(operator, filters);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof CompositeFilter)) {
        return false;
      }
      CompositeFilter other = (CompositeFilter) obj;
      return operator == other.operator
          && filters.equals(other.filters);
    }

    static CompositeFilter fromPb(com.google.datastore.v1beta3.CompositeFilter compositeFilterPb) {
      Operator operator = Operator.fromPb(compositeFilterPb.getOp());
      ImmutableList.Builder<Filter> filters = ImmutableList.builder();
      for (com.google.datastore.v1beta3.Filter filterPb : compositeFilterPb.getFiltersList()) {
        Filter currFilter = Filter.fromPb(filterPb);
        if (currFilter != null) {
          filters.add(currFilter);
        }
      }
      return new CompositeFilter(operator, filters.build());
    }

    public static CompositeFilter and(Filter first, Filter... other) {
      return new CompositeFilter(Operator.AND, first, other);
    }

    @Override
    protected com.google.datastore.v1beta3.Filter toPb() {
      com.google.datastore.v1beta3.Filter.Builder filterPb =
          com.google.datastore.v1beta3.Filter.newBuilder();
      com.google.datastore.v1beta3.CompositeFilter.Builder compositeFilterPb =
          filterPb.getCompositeFilterBuilder();
      compositeFilterPb.setOp(operator.toPb());
      for (Filter filter : filters) {
        compositeFilterPb.addFilters(filter.toPb());
      }
      return filterPb.build();
    }
  }

  /**
   * A class representing a filter based on a single property or ancestor.
   */
  public static final class PropertyFilter extends Filter {

    private static final long serialVersionUID = -4514695915258598597L;

    private final String property;
    private final Operator operator;
    private final Value<?> value;

    enum Operator {
      LESS_THAN,
      LESS_THAN_OR_EQUAL,
      GREATER_THAN,
      GREATER_THAN_OR_EQUAL,
      EQUAL,
      HAS_ANCESTOR;

      com.google.datastore.v1beta3.PropertyFilter.Operator toPb() {
        return com.google.datastore.v1beta3.PropertyFilter.Operator.valueOf(name());
      }

      static Operator fromPb(com.google.datastore.v1beta3.PropertyFilter.Operator operatorPb) {
        return valueOf(operatorPb.name());
      }
    }

    private PropertyFilter(String property, Operator operator, Value<?> value) {
      this.property = checkNotNull(property);
      this.operator = checkNotNull(operator);
      this.value = checkNotNull(value);
    }

    public static PropertyFilter fromPb(com.google.datastore.v1beta3.PropertyFilter propertyFilterPb) {
      String property = propertyFilterPb.getProperty().getName();
      Operator operator = Operator.fromPb(propertyFilterPb.getOp());
      Value<?> value = Value.fromPb(propertyFilterPb.getValue());
      return new PropertyFilter(property, operator, value);
    }

    @Override
    public String toString() {
      ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
      toStringHelper.add("property", property);
      toStringHelper.add("operator", operator);
      toStringHelper.add("value", value);
      return toStringHelper.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(property, operator, value);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof PropertyFilter)) {
        return false;
      }
      PropertyFilter other = (PropertyFilter) obj;
      return property.equals(other.property)
          && operator == other.operator
          && Objects.equals(value, other.value);
    }

    public static PropertyFilter lt(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.LESS_THAN, value);
    }

    public static PropertyFilter lt(String property, String value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, long value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, double value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, boolean value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, DateTime value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, Key value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter lt(String property, Blob value) {
      return new PropertyFilter(property, Operator.LESS_THAN, of(value));
    }

    public static PropertyFilter le(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, value);
    }

    public static PropertyFilter le(String property, String value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, long value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, double value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, boolean value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, DateTime value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, Key value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter le(String property, Blob value) {
      return new PropertyFilter(property, Operator.LESS_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter gt(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, value);
    }

    public static PropertyFilter gt(String property, String value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, long value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, double value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, boolean value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, DateTime value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, Key value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter gt(String property, Blob value) {
      return new PropertyFilter(property, Operator.GREATER_THAN, of(value));
    }

    public static PropertyFilter ge(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, value);
    }

    public static PropertyFilter ge(String property, String value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, long value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, double value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, boolean value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, DateTime value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, Key value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter ge(String property, Blob value) {
      return new PropertyFilter(property, Operator.GREATER_THAN_OR_EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Value<?> value) {
      return new PropertyFilter(property, Operator.EQUAL, value);
    }

    public static PropertyFilter eq(String property, String value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, long value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, double value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, boolean value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, DateTime value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Key value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter eq(String property, Blob value) {
      return new PropertyFilter(property, Operator.EQUAL, of(value));
    }

    public static PropertyFilter hasAncestor(Key key) {
      return new PropertyFilter(KEY_PROPERTY_NAME, Operator.HAS_ANCESTOR, of(key));
    }

    public static PropertyFilter isNull(String property) {
      return new PropertyFilter(property, Operator.EQUAL, NullValue.of());
    }

    @Override
    protected com.google.datastore.v1beta3.Filter toPb() {
      com.google.datastore.v1beta3.Filter.Builder filterPb =
          com.google.datastore.v1beta3.Filter.newBuilder();
      com.google.datastore.v1beta3.PropertyFilter.Builder propertyFilterPb =
          filterPb.getPropertyFilterBuilder();
      propertyFilterPb.getPropertyBuilder().setName(property);
      propertyFilterPb.setOp(operator.toPb());
      if (value != null) {
        propertyFilterPb.setValue(value.toPb());
      }
      return filterPb.build();
    }
  }

  public static final class OrderBy implements Serializable {

    private static final long serialVersionUID = 4091186784814400031L;

    private final String property;
    private final Direction direction;

    public enum Direction {

      ASCENDING, DESCENDING;

      com.google.datastore.v1beta3.PropertyOrder.Direction toPb() {
        return com.google.datastore.v1beta3.PropertyOrder.Direction.valueOf(name());
      }

      static Direction fromPb(com.google.datastore.v1beta3.PropertyOrder.Direction directionPb) {
        return valueOf(directionPb.name());
      }
    }

    public OrderBy(String property, Direction direction) {
      this.property = checkNotNull(property);
      this.direction = checkNotNull(direction);
    }

    @Override
    public int hashCode() {
      return Objects.hash(property, direction);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof OrderBy)) {
        return false;
      }
      OrderBy other = (OrderBy) obj;
      return property.equals(other.property)
          && direction == other.direction;
    }

    public String property() {
      return property;
    }

    public Direction direction() {
      return direction;
    }

    com.google.datastore.v1beta3.PropertyOrder toPb() {
      return com.google.datastore.v1beta3.PropertyOrder.newBuilder()
          .setDirection(direction.toPb())
          .setProperty(com.google.datastore.v1beta3.PropertyReference.newBuilder()
              .setName(property).build())
          .build();
    }

    public static OrderBy asc(String property) {
      return new OrderBy(property, OrderBy.Direction.ASCENDING);
    }

    public static OrderBy desc(String property) {
      return new OrderBy(property, OrderBy.Direction.DESCENDING);
    }

    static OrderBy fromPb(com.google.datastore.v1beta3.PropertyOrder propertyOrderPb) {
      String property = propertyOrderPb.getProperty().getName();
      Direction direction = Direction.fromPb(propertyOrderPb.getDirection());
      return new OrderBy(property, direction);
    }
  }

  static class BaseBuilder<V, B extends BaseBuilder<V, B>> {

    private final ResultType<V> resultType;
    private String namespace;
    private String kind;
    private final List<String> projection = new LinkedList<>();
    private Filter filter;
    private final List<String> distinctOn = new LinkedList<>();
    private final List<OrderBy> orderBy = new LinkedList<>();
    private Cursor startCursor;
    private Cursor endCursor;
    private int offset;
    private Integer limit;

    BaseBuilder(ResultType<V> resultType) {
      this.resultType = resultType;
    }

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    public B namespace(String namespace) {
      this.namespace = namespace;
      return self();
    }

    public B kind(String kind) {
      this.kind = kind;
      return self();
    }

    public B startCursor(Cursor startCursor) {
      this.startCursor = startCursor;
      return self();
    }

    public B endCursor(Cursor endCursor) {
      this.endCursor = endCursor;
      return self();
    }

    public B offset(int offset) {
      Preconditions.checkArgument(offset >= 0, "offset must not be negative");
      this.offset = offset;
      return self();
    }

    public B limit(Integer limit) {
      Preconditions.checkArgument(limit == null || limit > 0, "limit must be positive");
      this.limit = limit;
      return self();
    }

    public B filter(Filter filter) {
      this.filter = filter;
      return self();
    }

    public B clearOrderBy() {
      orderBy.clear();
      return self();
    }

    /**
     * Sets the query's order by clause (clearing any previously specified OrderBy settings).
     */
    public B orderBy(OrderBy orderBy, OrderBy... others) {
      clearOrderBy();
      addOrderBy(orderBy, others);
      return self();
    }

    /**
     * Adds settings to the existing order by clause.
     */
    public B addOrderBy(OrderBy orderBy, OrderBy... others) {
      this.orderBy.add(orderBy);
      Collections.addAll(this.orderBy, others);
      return self();
    }

    B clearProjection() {
      projection.clear();
      return self();
    }

    B projection(String projection, String... others) {
      clearProjection();
      addProjection(projection, others);
      return self();
    }

    B addProjection(String projection, String... others) {
      this.projection.add(projection);
      Collections.addAll(this.projection, others);
      return self();
    }

    B clearDistinctOn() {
      distinctOn.clear();
      return self();
    }

    B distinctOn(String property, String... others) {
      clearDistinctOn();
      addDistinctOn(property, others);
      return self();
    }

    B addDistinctOn(String property, String... others) {
      this.distinctOn.add(property);
      Collections.addAll(this.distinctOn, others);
      return self();
    }

    B mergeFrom(com.google.datastore.v1beta3.Query queryPb) {
      if (queryPb.getKindCount() > 0) {
        kind(queryPb.getKind(0).getName());
      }
      if (!queryPb.getStartCursor().isEmpty()) {
        startCursor(new Cursor(queryPb.getStartCursor()));
      }
      if (!queryPb.getEndCursor().isEmpty()) {
        endCursor(new Cursor(queryPb.getEndCursor()));
      }
      offset(queryPb.getOffset());
      if (queryPb.hasLimit()) {
        limit(queryPb.getLimit().getValue());
      }
      if (queryPb.hasFilter()) {
        Filter currFilter = Filter.fromPb(queryPb.getFilter());
        if (currFilter != null) {
          filter(currFilter);
        }
      }
      for (com.google.datastore.v1beta3.PropertyOrder orderByPb : queryPb.getOrderList()) {
        addOrderBy(OrderBy.fromPb(orderByPb));
      }
      for (com.google.datastore.v1beta3.Projection projectionPb
           : queryPb.getProjectionList()) {
        addProjection(projectionPb.getProperty().getName());
      }
      for (com.google.datastore.v1beta3.PropertyReference distinctOnPb : queryPb.getDistinctOnList()) {
        addDistinctOn(distinctOnPb.getName());
      }
      return self();
    }

    public StructuredQuery<V> build() {
      return new StructuredQuery<>(this);
    }
  }

  static final class Builder<V> extends BaseBuilder<V, Builder<V>> {

    Builder(ResultType<V> resultType) {
      super(resultType);
    }
  }

  /**
   * A StructuredQuery builder for queries that return Entity results.
   */
  public static final class EntityQueryBuilder extends BaseBuilder<Entity, EntityQueryBuilder> {

    EntityQueryBuilder() {
      super(ResultType.ENTITY);
    }

    @Override
    public StructuredQuery<Entity> build() {
      return new StructuredQuery<>(this);
    }
  }

  /**
   * A StructuredQuery builder for queries that return Key results.
   */
  public static final class KeyQueryBuilder extends BaseBuilder<Key, KeyQueryBuilder> {

    KeyQueryBuilder() {
      super(ResultType.KEY);
      projection(KEY_PROPERTY_NAME);
    }

    @Override
    protected KeyQueryBuilder mergeFrom(com.google.datastore.v1beta3.Query queryPb) {
      super.mergeFrom(queryPb);
      projection(KEY_PROPERTY_NAME);
      clearDistinctOn();
      return this;
    }

    @Override
    public StructuredQuery<Key> build() {
      return new StructuredQuery<>(this);
    }
  }

  /**
   * A StructuredQuery builder for projection queries.
   */
  public static final class ProjectionEntityQueryBuilder
      extends BaseBuilder<ProjectionEntity, ProjectionEntityQueryBuilder> {

    ProjectionEntityQueryBuilder() {
      super(ResultType.PROJECTION_ENTITY);
    }

    @Override
    public StructuredQuery<ProjectionEntity> build() {
      return new StructuredQuery<>(this);
    }

    @Override
    public ProjectionEntityQueryBuilder clearProjection() {
      return super.clearProjection();
    }

    /**
     * Sets the query's projection clause (clearing any previously specified Projection settings).
     */
    @Override
    public ProjectionEntityQueryBuilder projection(String projection, String... others) {
      return super.projection(projection, others);
    }

    /**
     * Adds one or more projections to the existing projection clause.
     */
    @Override
    public ProjectionEntityQueryBuilder addProjection(String projection, String... others) {
      return super.addProjection(projection, others);
    }

    @Override
    public ProjectionEntityQueryBuilder clearDistinctOn() {
      return super.clearDistinctOn();
    }

    /**
     * Sets the query's group by clause (clearing any previously specified GroupBy settings).
     */
    @Override
    public ProjectionEntityQueryBuilder distinctOn(String property, String... others) {
      return super.distinctOn(property, others);
    }

    /**
     * Adds one or more properties to the existing group by clause.
     */
    @Override
    public ProjectionEntityQueryBuilder addDistinctOn(String property, String... others) {
      return super.addDistinctOn(property, others);
    }
  }

  StructuredQuery(BaseBuilder<V, ?> builder) {
    super(builder.resultType, builder.namespace);
    kind = builder.kind;
    projection = ImmutableList.copyOf(builder.projection);
    filter = builder.filter;
    distinctOn = ImmutableList.copyOf(builder.distinctOn);
    orderBy = ImmutableList.copyOf(builder.orderBy);
    startCursor = builder.startCursor;
    endCursor = builder.endCursor;
    offset = builder.offset;
    limit = builder.limit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace(), kind, startCursor, endCursor, offset, limit, filter, orderBy,
distinctOn());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof StructuredQuery)) {
      return false;
    }
    StructuredQuery<?> other = (StructuredQuery<?>) obj;
    return Objects.equals(namespace(), other.namespace())
        && Objects.equals(kind, other.kind)
        && Objects.equals(startCursor, other.startCursor)
        && Objects.equals(endCursor, other.endCursor)
        && Objects.equals(offset, other.offset)
        && Objects.equals(limit, other.limit)
        && Objects.equals(filter, other.filter)
        && Objects.equals(orderBy, other.orderBy)
        && Objects.equals(projection, other.projection)
        && Objects.equals(distinctOn, other.distinctOn);

  }

  public String kind() {
    return kind;
  }

  boolean keyOnly() {
    return projection.size() == 1 && KEY_PROPERTY_NAME.equals(projection.get(0));
  }

  public List<String> projection() {
    return projection;
  }

  public Filter filter() {
    return filter;
  }

  public List<String> distinctOn() {
    return distinctOn;
  }

  public ImmutableList<OrderBy> orderBy() {
    return orderBy;
  }

  public Cursor startCursor() {
    return startCursor;
  }

  public Cursor endCursor() {
    return endCursor;
  }

  public int offset() {
    return offset;
  }

  public Integer limit() {
    return limit;
  }

  @Override
  protected void populatePb(com.google.datastore.v1beta3.RunQueryRequest.Builder requestPb) {
    requestPb.setQuery(toPb());
  }

  @Override
  protected Query<V> nextQuery(com.google.datastore.v1beta3.RunQueryResponse responsePb) {
    Builder<V> builder = new Builder<>(type());
    builder.mergeFrom(toPb());
    builder.startCursor(new Cursor(responsePb.getBatch().getEndCursor()));
    if (offset > 0 && responsePb.getBatch().getSkippedResults() < offset) {
      builder.offset(offset - responsePb.getBatch().getSkippedResults());
    } else {
      builder.offset(0);
      if (limit != null) {
        builder.limit(limit - responsePb.getBatch().getEntityResultsCount());
      }
    }
    return builder.build();
  }

  @Override
  protected com.google.datastore.v1beta3.Query toPb() {
    com.google.datastore.v1beta3.Query.Builder queryPb =
        com.google.datastore.v1beta3.Query.newBuilder();
    if (kind != null) {
      queryPb.addKindBuilder().setName(kind);
    }
    if (startCursor != null) {
      queryPb.setStartCursor(startCursor.byteString());
    }
    if (endCursor != null) {
      queryPb.setEndCursor(endCursor.byteString());
    }
    if (offset > 0) {
      queryPb.setOffset(offset);
    }
    if (limit != null) {
      queryPb.setLimit(com.google.protobuf.Int32Value.newBuilder().setValue(limit.intValue()));
    }
    if (filter != null) {
      queryPb.setFilter(filter.toPb());
    }
    for (OrderBy value : orderBy) {
      queryPb.addOrder(value.toPb());
    }
    for (String value : distinctOn) {
      queryPb.addDistinctOn(com.google.datastore.v1beta3.PropertyReference.newBuilder()
          .setName(value).build());
    }
    for (String value : projection) {
      com.google.datastore.v1beta3.Projection.Builder expressionPb =
          com.google.datastore.v1beta3.Projection.newBuilder();
      expressionPb.setProperty(
          com.google.datastore.v1beta3.PropertyReference.newBuilder().setName(value).build());
      queryPb.addProjection(expressionPb.build());
    }
    return queryPb.build();
  }

  @Override
  protected Object fromPb(ResultType<V> resultType, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException {
    return fromPb(resultType, namespace, com.google.datastore.v1beta3.Query.parseFrom(bytesPb));
  }

  @SuppressWarnings("unchecked")
  static <V> StructuredQuery<V> fromPb(
      ResultType<?> resultType, String namespace,
      com.google.datastore.v1beta3.Query queryPb) {
    BaseBuilder<?, ?> builder;
    if (resultType.equals(ResultType.ENTITY)) {
      builder = new EntityQueryBuilder();
    } else if (resultType.equals(ResultType.KEY)) {
      builder = new KeyQueryBuilder();
    } else {
      builder = new ProjectionEntityQueryBuilder();
    }
    return (StructuredQuery<V>) builder.namespace(namespace).mergeFrom(queryPb).build();
  }
}
