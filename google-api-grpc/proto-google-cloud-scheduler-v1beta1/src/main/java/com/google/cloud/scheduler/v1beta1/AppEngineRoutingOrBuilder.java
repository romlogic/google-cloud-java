// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/scheduler/v1beta1/target.proto

package com.google.cloud.scheduler.v1beta1;

public interface AppEngineRoutingOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.scheduler.v1beta1.AppEngineRouting)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * App service.
   * By default, the job is sent to the service which is the default
   * service when the job is attempted.
   * </pre>
   *
   * <code>string service = 1;</code>
   */
  java.lang.String getService();
  /**
   *
   *
   * <pre>
   * App service.
   * By default, the job is sent to the service which is the default
   * service when the job is attempted.
   * </pre>
   *
   * <code>string service = 1;</code>
   */
  com.google.protobuf.ByteString getServiceBytes();

  /**
   *
   *
   * <pre>
   * App version.
   * By default, the job is sent to the version which is the default
   * version when the job is attempted.
   * </pre>
   *
   * <code>string version = 2;</code>
   */
  java.lang.String getVersion();
  /**
   *
   *
   * <pre>
   * App version.
   * By default, the job is sent to the version which is the default
   * version when the job is attempted.
   * </pre>
   *
   * <code>string version = 2;</code>
   */
  com.google.protobuf.ByteString getVersionBytes();

  /**
   *
   *
   * <pre>
   * App instance.
   * By default, the job is sent to an instance which is available when
   * the job is attempted.
   * Requests can only be sent to a specific instance if
   * [manual scaling is used in App Engine Standard](https://cloud.google.com/appengine/docs/python/an-overview-of-app-engine?hl=en_US#scaling_types_and_instance_classes).
   * App Engine Flex does not support instances. For more information, see
   * [App Engine Standard request routing](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed) and
   * [App Engine Flex request routing](https://cloud.google.com/appengine/docs/flexible/python/how-requests-are-routed).
   * </pre>
   *
   * <code>string instance = 3;</code>
   */
  java.lang.String getInstance();
  /**
   *
   *
   * <pre>
   * App instance.
   * By default, the job is sent to an instance which is available when
   * the job is attempted.
   * Requests can only be sent to a specific instance if
   * [manual scaling is used in App Engine Standard](https://cloud.google.com/appengine/docs/python/an-overview-of-app-engine?hl=en_US#scaling_types_and_instance_classes).
   * App Engine Flex does not support instances. For more information, see
   * [App Engine Standard request routing](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed) and
   * [App Engine Flex request routing](https://cloud.google.com/appengine/docs/flexible/python/how-requests-are-routed).
   * </pre>
   *
   * <code>string instance = 3;</code>
   */
  com.google.protobuf.ByteString getInstanceBytes();

  /**
   *
   *
   * <pre>
   * Output only. The host that the job is sent to.
   * For more information about how App Engine requests are routed, see
   * [here](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed).
   * The host is constructed as:
   * * `host = [application_domain_name]`&lt;/br&gt;
   *   `| [service] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [version] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [version_dot_service]+ '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [instance] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [instance_dot_service] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [instance_dot_version] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [instance_dot_version_dot_service] + '.' + [application_domain_name]`
   * * `application_domain_name` = The domain name of the app, for
   *   example &lt;app-id&gt;.appspot.com, which is associated with the
   *   job's project ID.
   * * `service =` [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service]
   * * `version =` [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version]
   * * `version_dot_service =`
   *   [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version] `+ '.' +`
   *   [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service]
   * * `instance =` [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance]
   * * `instance_dot_service =`
   *   [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] `+ '.' +`
   *   [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service]
   * * `instance_dot_version =`
   *   [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] `+ '.' +`
   *   [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version]
   * * `instance_dot_version_dot_service =`
   *   [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] `+ '.' +`
   *   [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version] `+ '.' +`
   *   [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service]
   * If [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service] is empty, then the job will be sent
   * to the service which is the default service when the job is attempted.
   * If [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version] is empty, then the job will be sent
   * to the version which is the default version when the job is attempted.
   * If [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] is empty, then the job will be
   * sent to an instance which is available when the job is attempted.
   * If [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service],
   * [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version], or
   * [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] is invalid, then the job will be sent
   * to the default version of the default service when the job is attempted.
   * </pre>
   *
   * <code>string host = 4;</code>
   */
  java.lang.String getHost();
  /**
   *
   *
   * <pre>
   * Output only. The host that the job is sent to.
   * For more information about how App Engine requests are routed, see
   * [here](https://cloud.google.com/appengine/docs/standard/python/how-requests-are-routed).
   * The host is constructed as:
   * * `host = [application_domain_name]`&lt;/br&gt;
   *   `| [service] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [version] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [version_dot_service]+ '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [instance] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [instance_dot_service] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [instance_dot_version] + '.' + [application_domain_name]`&lt;/br&gt;
   *   `| [instance_dot_version_dot_service] + '.' + [application_domain_name]`
   * * `application_domain_name` = The domain name of the app, for
   *   example &lt;app-id&gt;.appspot.com, which is associated with the
   *   job's project ID.
   * * `service =` [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service]
   * * `version =` [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version]
   * * `version_dot_service =`
   *   [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version] `+ '.' +`
   *   [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service]
   * * `instance =` [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance]
   * * `instance_dot_service =`
   *   [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] `+ '.' +`
   *   [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service]
   * * `instance_dot_version =`
   *   [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] `+ '.' +`
   *   [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version]
   * * `instance_dot_version_dot_service =`
   *   [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] `+ '.' +`
   *   [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version] `+ '.' +`
   *   [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service]
   * If [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service] is empty, then the job will be sent
   * to the service which is the default service when the job is attempted.
   * If [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version] is empty, then the job will be sent
   * to the version which is the default version when the job is attempted.
   * If [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] is empty, then the job will be
   * sent to an instance which is available when the job is attempted.
   * If [service][google.cloud.scheduler.v1beta1.AppEngineRouting.service],
   * [version][google.cloud.scheduler.v1beta1.AppEngineRouting.version], or
   * [instance][google.cloud.scheduler.v1beta1.AppEngineRouting.instance] is invalid, then the job will be sent
   * to the default version of the default service when the job is attempted.
   * </pre>
   *
   * <code>string host = 4;</code>
   */
  com.google.protobuf.ByteString getHostBytes();
}
