// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/container/v1/cluster_service.proto

package com.google.container.v1;

/**
 *
 *
 * <pre>
 * Time window specified for daily maintenance operations.
 * </pre>
 *
 * Protobuf type {@code google.container.v1.DailyMaintenanceWindow}
 */
public final class DailyMaintenanceWindow extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.container.v1.DailyMaintenanceWindow)
    DailyMaintenanceWindowOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DailyMaintenanceWindow.newBuilder() to construct.
  private DailyMaintenanceWindow(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DailyMaintenanceWindow() {
    startTime_ = "";
    duration_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private DailyMaintenanceWindow(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 18:
            {
              java.lang.String s = input.readStringRequireUtf8();

              startTime_ = s;
              break;
            }
          case 26:
            {
              java.lang.String s = input.readStringRequireUtf8();

              duration_ = s;
              break;
            }
          default:
            {
              if (!parseUnknownFieldProto3(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.container.v1.ClusterServiceProto
        .internal_static_google_container_v1_DailyMaintenanceWindow_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.container.v1.ClusterServiceProto
        .internal_static_google_container_v1_DailyMaintenanceWindow_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.container.v1.DailyMaintenanceWindow.class,
            com.google.container.v1.DailyMaintenanceWindow.Builder.class);
  }

  public static final int START_TIME_FIELD_NUMBER = 2;
  private volatile java.lang.Object startTime_;
  /**
   *
   *
   * <pre>
   * Time within the maintenance window to start the maintenance operations.
   * Time format should be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
   * format "HH:MM”, where HH : [00-23] and MM : [00-59] GMT.
   * </pre>
   *
   * <code>string start_time = 2;</code>
   */
  public java.lang.String getStartTime() {
    java.lang.Object ref = startTime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      startTime_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * Time within the maintenance window to start the maintenance operations.
   * Time format should be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
   * format "HH:MM”, where HH : [00-23] and MM : [00-59] GMT.
   * </pre>
   *
   * <code>string start_time = 2;</code>
   */
  public com.google.protobuf.ByteString getStartTimeBytes() {
    java.lang.Object ref = startTime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      startTime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DURATION_FIELD_NUMBER = 3;
  private volatile java.lang.Object duration_;
  /**
   *
   *
   * <pre>
   * [Output only] Duration of the time window, automatically chosen to be
   * smallest possible in the given scenario.
   * Duration will be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
   * format "PTnHnMnS".
   * </pre>
   *
   * <code>string duration = 3;</code>
   */
  public java.lang.String getDuration() {
    java.lang.Object ref = duration_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      duration_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * [Output only] Duration of the time window, automatically chosen to be
   * smallest possible in the given scenario.
   * Duration will be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
   * format "PTnHnMnS".
   * </pre>
   *
   * <code>string duration = 3;</code>
   */
  public com.google.protobuf.ByteString getDurationBytes() {
    java.lang.Object ref = duration_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      duration_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (!getStartTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, startTime_);
    }
    if (!getDurationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, duration_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getStartTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, startTime_);
    }
    if (!getDurationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, duration_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.container.v1.DailyMaintenanceWindow)) {
      return super.equals(obj);
    }
    com.google.container.v1.DailyMaintenanceWindow other =
        (com.google.container.v1.DailyMaintenanceWindow) obj;

    boolean result = true;
    result = result && getStartTime().equals(other.getStartTime());
    result = result && getDuration().equals(other.getDuration());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + START_TIME_FIELD_NUMBER;
    hash = (53 * hash) + getStartTime().hashCode();
    hash = (37 * hash) + DURATION_FIELD_NUMBER;
    hash = (53 * hash) + getDuration().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.container.v1.DailyMaintenanceWindow parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.container.v1.DailyMaintenanceWindow prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * Time window specified for daily maintenance operations.
   * </pre>
   *
   * Protobuf type {@code google.container.v1.DailyMaintenanceWindow}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.container.v1.DailyMaintenanceWindow)
      com.google.container.v1.DailyMaintenanceWindowOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.container.v1.ClusterServiceProto
          .internal_static_google_container_v1_DailyMaintenanceWindow_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.container.v1.ClusterServiceProto
          .internal_static_google_container_v1_DailyMaintenanceWindow_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.container.v1.DailyMaintenanceWindow.class,
              com.google.container.v1.DailyMaintenanceWindow.Builder.class);
    }

    // Construct using com.google.container.v1.DailyMaintenanceWindow.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      startTime_ = "";

      duration_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.container.v1.ClusterServiceProto
          .internal_static_google_container_v1_DailyMaintenanceWindow_descriptor;
    }

    @java.lang.Override
    public com.google.container.v1.DailyMaintenanceWindow getDefaultInstanceForType() {
      return com.google.container.v1.DailyMaintenanceWindow.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.container.v1.DailyMaintenanceWindow build() {
      com.google.container.v1.DailyMaintenanceWindow result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.container.v1.DailyMaintenanceWindow buildPartial() {
      com.google.container.v1.DailyMaintenanceWindow result =
          new com.google.container.v1.DailyMaintenanceWindow(this);
      result.startTime_ = startTime_;
      result.duration_ = duration_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.container.v1.DailyMaintenanceWindow) {
        return mergeFrom((com.google.container.v1.DailyMaintenanceWindow) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.container.v1.DailyMaintenanceWindow other) {
      if (other == com.google.container.v1.DailyMaintenanceWindow.getDefaultInstance()) return this;
      if (!other.getStartTime().isEmpty()) {
        startTime_ = other.startTime_;
        onChanged();
      }
      if (!other.getDuration().isEmpty()) {
        duration_ = other.duration_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.container.v1.DailyMaintenanceWindow parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.container.v1.DailyMaintenanceWindow) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object startTime_ = "";
    /**
     *
     *
     * <pre>
     * Time within the maintenance window to start the maintenance operations.
     * Time format should be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "HH:MM”, where HH : [00-23] and MM : [00-59] GMT.
     * </pre>
     *
     * <code>string start_time = 2;</code>
     */
    public java.lang.String getStartTime() {
      java.lang.Object ref = startTime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        startTime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Time within the maintenance window to start the maintenance operations.
     * Time format should be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "HH:MM”, where HH : [00-23] and MM : [00-59] GMT.
     * </pre>
     *
     * <code>string start_time = 2;</code>
     */
    public com.google.protobuf.ByteString getStartTimeBytes() {
      java.lang.Object ref = startTime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        startTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Time within the maintenance window to start the maintenance operations.
     * Time format should be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "HH:MM”, where HH : [00-23] and MM : [00-59] GMT.
     * </pre>
     *
     * <code>string start_time = 2;</code>
     */
    public Builder setStartTime(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      startTime_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Time within the maintenance window to start the maintenance operations.
     * Time format should be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "HH:MM”, where HH : [00-23] and MM : [00-59] GMT.
     * </pre>
     *
     * <code>string start_time = 2;</code>
     */
    public Builder clearStartTime() {

      startTime_ = getDefaultInstance().getStartTime();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Time within the maintenance window to start the maintenance operations.
     * Time format should be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "HH:MM”, where HH : [00-23] and MM : [00-59] GMT.
     * </pre>
     *
     * <code>string start_time = 2;</code>
     */
    public Builder setStartTimeBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      startTime_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object duration_ = "";
    /**
     *
     *
     * <pre>
     * [Output only] Duration of the time window, automatically chosen to be
     * smallest possible in the given scenario.
     * Duration will be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "PTnHnMnS".
     * </pre>
     *
     * <code>string duration = 3;</code>
     */
    public java.lang.String getDuration() {
      java.lang.Object ref = duration_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        duration_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * [Output only] Duration of the time window, automatically chosen to be
     * smallest possible in the given scenario.
     * Duration will be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "PTnHnMnS".
     * </pre>
     *
     * <code>string duration = 3;</code>
     */
    public com.google.protobuf.ByteString getDurationBytes() {
      java.lang.Object ref = duration_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        duration_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * [Output only] Duration of the time window, automatically chosen to be
     * smallest possible in the given scenario.
     * Duration will be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "PTnHnMnS".
     * </pre>
     *
     * <code>string duration = 3;</code>
     */
    public Builder setDuration(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      duration_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * [Output only] Duration of the time window, automatically chosen to be
     * smallest possible in the given scenario.
     * Duration will be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "PTnHnMnS".
     * </pre>
     *
     * <code>string duration = 3;</code>
     */
    public Builder clearDuration() {

      duration_ = getDefaultInstance().getDuration();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * [Output only] Duration of the time window, automatically chosen to be
     * smallest possible in the given scenario.
     * Duration will be in [RFC3339](https://www.ietf.org/rfc/rfc3339.txt)
     * format "PTnHnMnS".
     * </pre>
     *
     * <code>string duration = 3;</code>
     */
    public Builder setDurationBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      duration_ = value;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.container.v1.DailyMaintenanceWindow)
  }

  // @@protoc_insertion_point(class_scope:google.container.v1.DailyMaintenanceWindow)
  private static final com.google.container.v1.DailyMaintenanceWindow DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.container.v1.DailyMaintenanceWindow();
  }

  public static com.google.container.v1.DailyMaintenanceWindow getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DailyMaintenanceWindow> PARSER =
      new com.google.protobuf.AbstractParser<DailyMaintenanceWindow>() {
        @java.lang.Override
        public DailyMaintenanceWindow parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new DailyMaintenanceWindow(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<DailyMaintenanceWindow> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DailyMaintenanceWindow> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.container.v1.DailyMaintenanceWindow getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
