package com.nova.user.utils;

public class UserConstants {

    /**
     * Instantiates a new mom constants.
     */
    private UserConstants() {
        throw new IllegalStateException("Constants class");
    }

    public static final String CONFIG_PATH_VERSION = "/api/usermanagement/v1";

    public static final String USER_DEFAULT_GROUP_CREATION="/userdefaultgroupcreation";

    public static final String USER_GROUP_DETAILS="/usergroupdetails";

    public static final String USER_GROUP_ID="/{userGroupId}";

    public static final String CUSTOMER_MAPPER_ID="/{customerMapperId}";

    public static final String USER_DETAILS="/userdetails";

}
