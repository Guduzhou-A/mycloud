package org.gdz.mycloud.common.base.util;

/**
 * @Author: guduzhou
 * @Description: redis key工具类
 * @Date: Created in 14:07 2020/5/8 0008
 * @Modified By:
 */
public class RedisKeyUtils {

    public static String signInErrorCountKey(String uuid, String userCode) {
        return String.format("ERROR_COUNT:UID:{%s}:USER:{%s}:INTEGER", uuid, userCode);
    }

    public static String userInfoKey(String uuid, String userCode) {
        return String.format("LOGIN:UID:{%s}:USER:{%s}:HASH", uuid, userCode);
    }

    public static String userInfoHashKey() {
        return "BASIC:INFO:JSON";
    }

    public static String userAccessTokenHashKey() {
        return "ACCESS:TOKEN:STRING";
    }


    public static String userRoleHashKey() {
        return "ROLE:JSON";
    }

    public static String userApiHashKey() {
        return "ROLE:API:JSON";
    }

    public static String roleResourceMapping() {
        return "BASIC:ROLE:RESOURCE:MAPPING:JSON";
    }

    public static String roleResourceApiMapping() {
        return "BASIC:ROLE:API:MAPPING:JSON";
    }

    public static String smsCodeExpireKey(String mobile) {
        return String.format("SMS:EXPIRE:MOBILE:{%s}:NULL", mobile);
    }

    public static String supplierCodeKey(String supplierCode) {
        return String.format("CONTRACT:SUPPLIER:CODE:{%s}:HASH", supplierCode);
    }

    public static String supplierCategoryHashKey(String categoryCode, String categoryName) {
        return String.format("%s:%s", categoryCode, categoryName);
    }

    public static String loginHistoryKey(String uuid, String userCode) {
        return String.format("HISTORY:LOGIN:UID:{%s}:USER:{%s}:HASH", uuid, userCode);
    }

    public static String loginHistoryAccessTimeKey() {
        return "TIME:STRING";
    }

    public static String loginHistoryLastAccessTimeKey() {
        return "LAST_TIME:STRING";
    }
    public static String loginHistoryAccessIpKey() {
        return "IP:STRING";
    }


    public static String loginHistoryLastAccessIpKey() {
        return "LAST_IP:STRING";
    }

}
