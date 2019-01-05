// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/videointelligence/v1p2beta1/video_intelligence.proto

package com.google.cloud.videointelligence.v1p2beta1;

/**
 *
 *
 * <pre>
 * Label detection mode.
 * </pre>
 *
 * Protobuf enum {@code google.cloud.videointelligence.v1p2beta1.LabelDetectionMode}
 */
public enum LabelDetectionMode implements com.google.protobuf.ProtocolMessageEnum {
  /**
   *
   *
   * <pre>
   * Unspecified.
   * </pre>
   *
   * <code>LABEL_DETECTION_MODE_UNSPECIFIED = 0;</code>
   */
  LABEL_DETECTION_MODE_UNSPECIFIED(0),
  /**
   *
   *
   * <pre>
   * Detect shot-level labels.
   * </pre>
   *
   * <code>SHOT_MODE = 1;</code>
   */
  SHOT_MODE(1),
  /**
   *
   *
   * <pre>
   * Detect frame-level labels.
   * </pre>
   *
   * <code>FRAME_MODE = 2;</code>
   */
  FRAME_MODE(2),
  /**
   *
   *
   * <pre>
   * Detect both shot-level and frame-level labels.
   * </pre>
   *
   * <code>SHOT_AND_FRAME_MODE = 3;</code>
   */
  SHOT_AND_FRAME_MODE(3),
  UNRECOGNIZED(-1),
  ;

  /**
   *
   *
   * <pre>
   * Unspecified.
   * </pre>
   *
   * <code>LABEL_DETECTION_MODE_UNSPECIFIED = 0;</code>
   */
  public static final int LABEL_DETECTION_MODE_UNSPECIFIED_VALUE = 0;
  /**
   *
   *
   * <pre>
   * Detect shot-level labels.
   * </pre>
   *
   * <code>SHOT_MODE = 1;</code>
   */
  public static final int SHOT_MODE_VALUE = 1;
  /**
   *
   *
   * <pre>
   * Detect frame-level labels.
   * </pre>
   *
   * <code>FRAME_MODE = 2;</code>
   */
  public static final int FRAME_MODE_VALUE = 2;
  /**
   *
   *
   * <pre>
   * Detect both shot-level and frame-level labels.
   * </pre>
   *
   * <code>SHOT_AND_FRAME_MODE = 3;</code>
   */
  public static final int SHOT_AND_FRAME_MODE_VALUE = 3;

  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /** @deprecated Use {@link #forNumber(int)} instead. */
  @java.lang.Deprecated
  public static LabelDetectionMode valueOf(int value) {
    return forNumber(value);
  }

  public static LabelDetectionMode forNumber(int value) {
    switch (value) {
      case 0:
        return LABEL_DETECTION_MODE_UNSPECIFIED;
      case 1:
        return SHOT_MODE;
      case 2:
        return FRAME_MODE;
      case 3:
        return SHOT_AND_FRAME_MODE;
      default:
        return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<LabelDetectionMode> internalGetValueMap() {
    return internalValueMap;
  }

  private static final com.google.protobuf.Internal.EnumLiteMap<LabelDetectionMode>
      internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<LabelDetectionMode>() {
            public LabelDetectionMode findValueByNumber(int number) {
              return LabelDetectionMode.forNumber(number);
            }
          };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }

  public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
    return getDescriptor();
  }

  public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
    return com.google.cloud.videointelligence.v1p2beta1.VideoIntelligenceServiceProto
        .getDescriptor()
        .getEnumTypes()
        .get(1);
  }

  private static final LabelDetectionMode[] VALUES = values();

  public static LabelDetectionMode valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private LabelDetectionMode(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:google.cloud.videointelligence.v1p2beta1.LabelDetectionMode)
}
