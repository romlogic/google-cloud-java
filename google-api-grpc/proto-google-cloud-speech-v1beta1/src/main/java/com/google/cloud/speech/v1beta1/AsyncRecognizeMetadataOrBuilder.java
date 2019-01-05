// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/speech/v1beta1/cloud_speech.proto

package com.google.cloud.speech.v1beta1;

public interface AsyncRecognizeMetadataOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.speech.v1beta1.AsyncRecognizeMetadata)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Approximate percentage of audio processed thus far. Guaranteed to be 100
   * when the audio is fully processed and the results are available.
   * </pre>
   *
   * <code>int32 progress_percent = 1;</code>
   */
  int getProgressPercent();

  /**
   *
   *
   * <pre>
   * Time when the request was received.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp start_time = 2;</code>
   */
  boolean hasStartTime();
  /**
   *
   *
   * <pre>
   * Time when the request was received.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp start_time = 2;</code>
   */
  com.google.protobuf.Timestamp getStartTime();
  /**
   *
   *
   * <pre>
   * Time when the request was received.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp start_time = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getStartTimeOrBuilder();

  /**
   *
   *
   * <pre>
   * Time of the most recent processing update.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp last_update_time = 3;</code>
   */
  boolean hasLastUpdateTime();
  /**
   *
   *
   * <pre>
   * Time of the most recent processing update.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp last_update_time = 3;</code>
   */
  com.google.protobuf.Timestamp getLastUpdateTime();
  /**
   *
   *
   * <pre>
   * Time of the most recent processing update.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp last_update_time = 3;</code>
   */
  com.google.protobuf.TimestampOrBuilder getLastUpdateTimeOrBuilder();
}
