package org.gdz.mycloud.common.base.enums;

/**
 * 业务Code
 *
 * @author guduz
 */
public enum BussinessCode {
    /**
     *  枚举命名规则
     *  模块名_功能名_错误名
     *
     */

    /**
     * 系统及服务错误代码
     * 100 系统底层
     * 101 功能代码 递增
     * 001 错误ID 递增
     */

    SYSTEM_BASIC_NORMAL_ERROR(100101001, "系统错误"),

    SYSTEM_REQUEST_SERVICE_UNAVAILABLE(100102001, "服务不可访问"),
    SYSTEM_REQUEST_REMOTE_SERVICE_ERROR(100102002, "远程服务错误"),
    SYSTEM_REQUEST_API_ERROR(100102003, "接口错误"),
    SYSTEM_REQUEST_ILLEGAL_REQUEST(100102004, "非法请求"),
    SYSTEM_REQUEST_UNAUTHORIZED(100102005, "参数错误"),
    SYSTEM_REQUEST_API_NOT_FOUND(100102006, "接口不存在"),
    SYSTEM_REQUEST_BAD_REQUEST(100102007, "请求的HTTP METHOD不支持，请检查是否选择了正确的POST/GET方式"),
    SYSTEM_REQUEST_DATA_NOT_FOUND(100102008, "数据错误或与服务器不一致,资源无法访问或不存在"),

    SYSTEM_RESPONSE_SUCCESS(100103001, "执行成功"),
    SYSTEM_RESPONSE_ERROR(100103002, "执行失败");

    private int code;
    private String msg;

    /**
     * Msg string.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    BussinessCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     * @return the enum
     */
    public static BussinessCode getEnum(int code) {
        for (BussinessCode ele : BussinessCode.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }

}
