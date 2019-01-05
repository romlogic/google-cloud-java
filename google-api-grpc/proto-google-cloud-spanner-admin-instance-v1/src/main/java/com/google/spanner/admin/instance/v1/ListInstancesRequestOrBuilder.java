// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/spanner/admin/instance/v1/spanner_instance_admin.proto

package com.google.spanner.admin.instance.v1;

public interface ListInstancesRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.admin.instance.v1.ListInstancesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The name of the project for which a list of instances is
   * requested. Values are of the form `projects/&lt;project&gt;`.
   * </pre>
   *
   * <code>string parent = 1;</code>
   */
  java.lang.String getParent();
  /**
   *
   *
   * <pre>
   * Required. The name of the project for which a list of instances is
   * requested. Values are of the form `projects/&lt;project&gt;`.
   * </pre>
   *
   * <code>string parent = 1;</code>
   */
  com.google.protobuf.ByteString getParentBytes();

  /**
   *
   *
   * <pre>
   * Number of instances to be returned in the response. If 0 or less, defaults
   * to the server's maximum allowed page size.
   * </pre>
   *
   * <code>int32 page_size = 2;</code>
   */
  int getPageSize();

  /**
   *
   *
   * <pre>
   * If non-empty, `page_token` should contain a
   * [next_page_token][google.spanner.admin.instance.v1.ListInstancesResponse.next_page_token] from a
   * previous [ListInstancesResponse][google.spanner.admin.instance.v1.ListInstancesResponse].
   * </pre>
   *
   * <code>string page_token = 3;</code>
   */
  java.lang.String getPageToken();
  /**
   *
   *
   * <pre>
   * If non-empty, `page_token` should contain a
   * [next_page_token][google.spanner.admin.instance.v1.ListInstancesResponse.next_page_token] from a
   * previous [ListInstancesResponse][google.spanner.admin.instance.v1.ListInstancesResponse].
   * </pre>
   *
   * <code>string page_token = 3;</code>
   */
  com.google.protobuf.ByteString getPageTokenBytes();

  /**
   *
   *
   * <pre>
   * An expression for filtering the results of the request. Filter rules are
   * case insensitive. The fields eligible for filtering are:
   *   * `name`
   *   * `display_name`
   *   * `labels.key` where key is the name of a label
   * Some examples of using filters are:
   *   * `name:*` --&gt; The instance has a name.
   *   * `name:Howl` --&gt; The instance's name contains the string "howl".
   *   * `name:HOWL` --&gt; Equivalent to above.
   *   * `NAME:howl` --&gt; Equivalent to above.
   *   * `labels.env:*` --&gt; The instance has the label "env".
   *   * `labels.env:dev` --&gt; The instance has the label "env" and the value of
   *                        the label contains the string "dev".
   *   * `name:howl labels.env:dev` --&gt; The instance's name contains "howl" and
   *                                  it has the label "env" with its value
   *                                  containing "dev".
   * </pre>
   *
   * <code>string filter = 4;</code>
   */
  java.lang.String getFilter();
  /**
   *
   *
   * <pre>
   * An expression for filtering the results of the request. Filter rules are
   * case insensitive. The fields eligible for filtering are:
   *   * `name`
   *   * `display_name`
   *   * `labels.key` where key is the name of a label
   * Some examples of using filters are:
   *   * `name:*` --&gt; The instance has a name.
   *   * `name:Howl` --&gt; The instance's name contains the string "howl".
   *   * `name:HOWL` --&gt; Equivalent to above.
   *   * `NAME:howl` --&gt; Equivalent to above.
   *   * `labels.env:*` --&gt; The instance has the label "env".
   *   * `labels.env:dev` --&gt; The instance has the label "env" and the value of
   *                        the label contains the string "dev".
   *   * `name:howl labels.env:dev` --&gt; The instance's name contains "howl" and
   *                                  it has the label "env" with its value
   *                                  containing "dev".
   * </pre>
   *
   * <code>string filter = 4;</code>
   */
  com.google.protobuf.ByteString getFilterBytes();
}
