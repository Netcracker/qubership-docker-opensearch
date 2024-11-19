package com.netcracker.opensearch;

public class Constants {

  public static final String RESOURCE_PREFIX_ATTRIBUTE_NAME = "attr.internal.resource_prefix";

  public static final String OPENDISTRO_SECURITY_USER = "_opendistro_security_user";

  public static final String ISM_ACTION_PATTERN = "cluster:admin/opendistro/ism";
  public static final String ISM_CONFIG_INDEX_NAME = ".opendistro-ism-config";
  public static final String ISM_ROLE_NAME = "dbaas_ism";

  public static final String ADD_POLICY_ACTION_NAME =
      "cluster:admin/opendistro/ism/managedindex/add";
  public static final String CHANGE_POLICY_ACTION_NAME =
      "cluster:admin/opendistro/ism/managedindex/change";
  public static final String DELETE_POLICY_ACTION_NAME =
      "cluster:admin/opendistro/ism/policy/delete";
  public static final String EXPLAIN_ACTION_NAME =
      "cluster:admin/opendistro/ism/managedindex/explain";
  public static final String GET_POLICIES_ACTION_NAME =
      "cluster:admin/opendistro/ism/policy/search";
  public static final String GET_POLICY_ACTION_NAME = "cluster:admin/opendistro/ism/policy/get";
  public static final String INDEX_POLICY_ACTION_NAME = "cluster:admin/opendistro/ism/policy/write";
  public static final String REMOVE_POLICY_ACTION_NAME =
      "cluster:admin/opendistro/ism/managedindex/remove";
  public static final String RETRY_FAILED_MANAGED_INDEX_ACTION_NAME =
      "cluster:admin/opendistro/ism/managedindex/retry";
}
