// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/iot/v1/resources.proto

package com.google.cloud.iot.v1;

/**
 *
 *
 * <pre>
 * The gateway authorization/authentication method. This setting determines how
 * Cloud IoT Core authorizes/authenticate devices to access the gateway.
 * </pre>
 *
 * Protobuf enum {@code google.cloud.iot.v1.GatewayAuthMethod}
 */
public enum GatewayAuthMethod implements com.google.protobuf.ProtocolMessageEnum {
  /**
   *
   *
   * <pre>
   * No authentication/authorization method specified. No devices are allowed to
   * access the gateway.
   * </pre>
   *
   * <code>GATEWAY_AUTH_METHOD_UNSPECIFIED = 0;</code>
   */
  GATEWAY_AUTH_METHOD_UNSPECIFIED(0),
  /**
   *
   *
   * <pre>
   * The device is authenticated through the gateway association only. Device
   * credentials are ignored even if provided.
   * </pre>
   *
   * <code>ASSOCIATION_ONLY = 1;</code>
   */
  ASSOCIATION_ONLY(1),
  /**
   *
   *
   * <pre>
   * The device is authenticated through its own credentials. Gateway
   * association is not checked.
   * </pre>
   *
   * <code>DEVICE_AUTH_TOKEN_ONLY = 2;</code>
   */
  DEVICE_AUTH_TOKEN_ONLY(2),
  /**
   *
   *
   * <pre>
   * The device is authenticated through both device credentials and gateway
   * association. The device must be bound to the gateway and must provide its
   * own credentials.
   * </pre>
   *
   * <code>ASSOCIATION_AND_DEVICE_AUTH_TOKEN = 3;</code>
   */
  ASSOCIATION_AND_DEVICE_AUTH_TOKEN(3),
  UNRECOGNIZED(-1),
  ;

  /**
   *
   *
   * <pre>
   * No authentication/authorization method specified. No devices are allowed to
   * access the gateway.
   * </pre>
   *
   * <code>GATEWAY_AUTH_METHOD_UNSPECIFIED = 0;</code>
   */
  public static final int GATEWAY_AUTH_METHOD_UNSPECIFIED_VALUE = 0;
  /**
   *
   *
   * <pre>
   * The device is authenticated through the gateway association only. Device
   * credentials are ignored even if provided.
   * </pre>
   *
   * <code>ASSOCIATION_ONLY = 1;</code>
   */
  public static final int ASSOCIATION_ONLY_VALUE = 1;
  /**
   *
   *
   * <pre>
   * The device is authenticated through its own credentials. Gateway
   * association is not checked.
   * </pre>
   *
   * <code>DEVICE_AUTH_TOKEN_ONLY = 2;</code>
   */
  public static final int DEVICE_AUTH_TOKEN_ONLY_VALUE = 2;
  /**
   *
   *
   * <pre>
   * The device is authenticated through both device credentials and gateway
   * association. The device must be bound to the gateway and must provide its
   * own credentials.
   * </pre>
   *
   * <code>ASSOCIATION_AND_DEVICE_AUTH_TOKEN = 3;</code>
   */
  public static final int ASSOCIATION_AND_DEVICE_AUTH_TOKEN_VALUE = 3;

  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /** @deprecated Use {@link #forNumber(int)} instead. */
  @java.lang.Deprecated
  public static GatewayAuthMethod valueOf(int value) {
    return forNumber(value);
  }

  public static GatewayAuthMethod forNumber(int value) {
    switch (value) {
      case 0:
        return GATEWAY_AUTH_METHOD_UNSPECIFIED;
      case 1:
        return ASSOCIATION_ONLY;
      case 2:
        return DEVICE_AUTH_TOKEN_ONLY;
      case 3:
        return ASSOCIATION_AND_DEVICE_AUTH_TOKEN;
      default:
        return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<GatewayAuthMethod> internalGetValueMap() {
    return internalValueMap;
  }

  private static final com.google.protobuf.Internal.EnumLiteMap<GatewayAuthMethod>
      internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<GatewayAuthMethod>() {
            public GatewayAuthMethod findValueByNumber(int number) {
              return GatewayAuthMethod.forNumber(number);
            }
          };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }

  public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
    return getDescriptor();
  }

  public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
    return com.google.cloud.iot.v1.ResourcesProto.getDescriptor().getEnumTypes().get(4);
  }

  private static final GatewayAuthMethod[] VALUES = values();

  public static GatewayAuthMethod valueOf(
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

  private GatewayAuthMethod(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:google.cloud.iot.v1.GatewayAuthMethod)
}
