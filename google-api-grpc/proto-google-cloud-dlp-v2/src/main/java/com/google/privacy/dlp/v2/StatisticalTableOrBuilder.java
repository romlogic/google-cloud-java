// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/privacy/dlp/v2/dlp.proto

package com.google.privacy.dlp.v2;

public interface StatisticalTableOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.privacy.dlp.v2.StatisticalTable)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Auxiliary table location. [required]
   * </pre>
   *
   * <code>.google.privacy.dlp.v2.BigQueryTable table = 3;</code>
   */
  boolean hasTable();
  /**
   *
   *
   * <pre>
   * Auxiliary table location. [required]
   * </pre>
   *
   * <code>.google.privacy.dlp.v2.BigQueryTable table = 3;</code>
   */
  com.google.privacy.dlp.v2.BigQueryTable getTable();
  /**
   *
   *
   * <pre>
   * Auxiliary table location. [required]
   * </pre>
   *
   * <code>.google.privacy.dlp.v2.BigQueryTable table = 3;</code>
   */
  com.google.privacy.dlp.v2.BigQueryTableOrBuilder getTableOrBuilder();

  /**
   *
   *
   * <pre>
   * Quasi-identifier columns. [required]
   * </pre>
   *
   * <code>repeated .google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierField quasi_ids = 1;
   * </code>
   */
  java.util.List<com.google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierField> getQuasiIdsList();
  /**
   *
   *
   * <pre>
   * Quasi-identifier columns. [required]
   * </pre>
   *
   * <code>repeated .google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierField quasi_ids = 1;
   * </code>
   */
  com.google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierField getQuasiIds(int index);
  /**
   *
   *
   * <pre>
   * Quasi-identifier columns. [required]
   * </pre>
   *
   * <code>repeated .google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierField quasi_ids = 1;
   * </code>
   */
  int getQuasiIdsCount();
  /**
   *
   *
   * <pre>
   * Quasi-identifier columns. [required]
   * </pre>
   *
   * <code>repeated .google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierField quasi_ids = 1;
   * </code>
   */
  java.util.List<? extends com.google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierFieldOrBuilder>
      getQuasiIdsOrBuilderList();
  /**
   *
   *
   * <pre>
   * Quasi-identifier columns. [required]
   * </pre>
   *
   * <code>repeated .google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierField quasi_ids = 1;
   * </code>
   */
  com.google.privacy.dlp.v2.StatisticalTable.QuasiIdentifierFieldOrBuilder getQuasiIdsOrBuilder(
      int index);

  /**
   *
   *
   * <pre>
   * The relative frequency column must contain a floating-point number
   * between 0 and 1 (inclusive). Null values are assumed to be zero.
   * [required]
   * </pre>
   *
   * <code>.google.privacy.dlp.v2.FieldId relative_frequency = 2;</code>
   */
  boolean hasRelativeFrequency();
  /**
   *
   *
   * <pre>
   * The relative frequency column must contain a floating-point number
   * between 0 and 1 (inclusive). Null values are assumed to be zero.
   * [required]
   * </pre>
   *
   * <code>.google.privacy.dlp.v2.FieldId relative_frequency = 2;</code>
   */
  com.google.privacy.dlp.v2.FieldId getRelativeFrequency();
  /**
   *
   *
   * <pre>
   * The relative frequency column must contain a floating-point number
   * between 0 and 1 (inclusive). Null values are assumed to be zero.
   * [required]
   * </pre>
   *
   * <code>.google.privacy.dlp.v2.FieldId relative_frequency = 2;</code>
   */
  com.google.privacy.dlp.v2.FieldIdOrBuilder getRelativeFrequencyOrBuilder();
}
