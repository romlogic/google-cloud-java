// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/language/v1/language_service.proto

package com.google.cloud.language.v1;

public interface DependencyEdgeOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.language.v1.DependencyEdge)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Represents the head of this token in the dependency tree.
   * This is the index of the token which has an arc going to this token.
   * The index is the position of the token in the array of tokens returned
   * by the API method. If this token is a root token, then the
   * `head_token_index` is its own index.
   * </pre>
   *
   * <code>int32 head_token_index = 1;</code>
   */
  int getHeadTokenIndex();

  /**
   *
   *
   * <pre>
   * The parse label for the token.
   * </pre>
   *
   * <code>.google.cloud.language.v1.DependencyEdge.Label label = 2;</code>
   */
  int getLabelValue();
  /**
   *
   *
   * <pre>
   * The parse label for the token.
   * </pre>
   *
   * <code>.google.cloud.language.v1.DependencyEdge.Label label = 2;</code>
   */
  com.google.cloud.language.v1.DependencyEdge.Label getLabel();
}
