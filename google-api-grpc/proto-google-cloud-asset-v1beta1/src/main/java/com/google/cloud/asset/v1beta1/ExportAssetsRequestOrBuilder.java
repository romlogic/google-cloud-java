// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/asset/v1beta1/asset_service.proto

package com.google.cloud.asset.v1beta1;

public interface ExportAssetsRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.asset.v1beta1.ExportAssetsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The relative name of the root asset. This can only be an organization
   * number (such as "organizations/123"), a project ID (such as
   * "projects/my-project-id"), or a project number (such as "projects/12345").
   * </pre>
   *
   * <code>string parent = 1;</code>
   */
  java.lang.String getParent();
  /**
   *
   *
   * <pre>
   * Required. The relative name of the root asset. This can only be an organization
   * number (such as "organizations/123"), a project ID (such as
   * "projects/my-project-id"), or a project number (such as "projects/12345").
   * </pre>
   *
   * <code>string parent = 1;</code>
   */
  com.google.protobuf.ByteString getParentBytes();

  /**
   *
   *
   * <pre>
   * Timestamp to take an asset snapshot. This can only be set to a timestamp in
   * the past or of the current time. If not specified, the current time will be
   * used. Due to delays in resource data collection and indexing, there is a
   * volatile window during which running the same query may get different
   * results.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp read_time = 2;</code>
   */
  boolean hasReadTime();
  /**
   *
   *
   * <pre>
   * Timestamp to take an asset snapshot. This can only be set to a timestamp in
   * the past or of the current time. If not specified, the current time will be
   * used. Due to delays in resource data collection and indexing, there is a
   * volatile window during which running the same query may get different
   * results.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp read_time = 2;</code>
   */
  com.google.protobuf.Timestamp getReadTime();
  /**
   *
   *
   * <pre>
   * Timestamp to take an asset snapshot. This can only be set to a timestamp in
   * the past or of the current time. If not specified, the current time will be
   * used. Due to delays in resource data collection and indexing, there is a
   * volatile window during which running the same query may get different
   * results.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp read_time = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getReadTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * A list of asset types of which to take a snapshot for. For example:
   * "google.compute.disk". If specified, only matching assets will be returned.
   * </pre>
   *
   * <code>repeated string asset_types = 3;</code>
   */
  java.util.List<java.lang.String> getAssetTypesList();
  /**
   *
   *
   * <pre>
   * A list of asset types of which to take a snapshot for. For example:
   * "google.compute.disk". If specified, only matching assets will be returned.
   * </pre>
   *
   * <code>repeated string asset_types = 3;</code>
   */
  int getAssetTypesCount();
  /**
   *
   *
   * <pre>
   * A list of asset types of which to take a snapshot for. For example:
   * "google.compute.disk". If specified, only matching assets will be returned.
   * </pre>
   *
   * <code>repeated string asset_types = 3;</code>
   */
  java.lang.String getAssetTypes(int index);
  /**
   *
   *
   * <pre>
   * A list of asset types of which to take a snapshot for. For example:
   * "google.compute.disk". If specified, only matching assets will be returned.
   * </pre>
   *
   * <code>repeated string asset_types = 3;</code>
   */
  com.google.protobuf.ByteString getAssetTypesBytes(int index);

  /**
   *
   *
   * <pre>
   * Asset content type. If not specified, no content but the asset name will be
   * returned.
   * </pre>
   *
   * <code>.google.cloud.asset.v1beta1.ContentType content_type = 4;</code>
   */
  int getContentTypeValue();
  /**
   *
   *
   * <pre>
   * Asset content type. If not specified, no content but the asset name will be
   * returned.
   * </pre>
   *
   * <code>.google.cloud.asset.v1beta1.ContentType content_type = 4;</code>
   */
  com.google.cloud.asset.v1beta1.ContentType getContentType();

  /**
   *
   *
   * <pre>
   * Required. Output configuration indicating where the results will be output
   * to. All results will be in newline delimited JSON format.
   * </pre>
   *
   * <code>.google.cloud.asset.v1beta1.OutputConfig output_config = 5;</code>
   */
  boolean hasOutputConfig();
  /**
   *
   *
   * <pre>
   * Required. Output configuration indicating where the results will be output
   * to. All results will be in newline delimited JSON format.
   * </pre>
   *
   * <code>.google.cloud.asset.v1beta1.OutputConfig output_config = 5;</code>
   */
  com.google.cloud.asset.v1beta1.OutputConfig getOutputConfig();
  /**
   *
   *
   * <pre>
   * Required. Output configuration indicating where the results will be output
   * to. All results will be in newline delimited JSON format.
   * </pre>
   *
   * <code>.google.cloud.asset.v1beta1.OutputConfig output_config = 5;</code>
   */
  com.google.cloud.asset.v1beta1.OutputConfigOrBuilder getOutputConfigOrBuilder();
}
