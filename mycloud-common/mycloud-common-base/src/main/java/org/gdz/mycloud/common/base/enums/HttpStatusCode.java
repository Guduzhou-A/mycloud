package org.gdz.mycloud.common.base.enums;

/**
 * Http状态码Code
 *
 * @author guduz
 */
public enum HttpStatusCode {

    /**
     * HttpCode
     */
    RESPONSE_SUCCESS(200, "执行成功"),
    RESPONSE_SERVER_EXCEPTION(500, "服务端错误"),
    RESPONSE_ERROR(400, "程序错误"),
    RESPONSE_CONTENT_IS_NULL(204, "没有参数"),
    RESPONSE_UNAUTHORIZED(401, "非法数据,或者参数对应信息未找到"),
    RESPONSE_NOT_MODIFIED(304, "没有数据被修改"),
    RESPONSE_NOT_FOUND(404, "未找到数据"),
    RESPONSE_FORBIDDEN(403, "禁止访问"),
    RESPONSE_CONFLICT(409, "数据参数与服务器产生冲突");

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

    HttpStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     * @return the enum
     */
    public static HttpStatusCode getEnum(int code) {
        for (HttpStatusCode ele : HttpStatusCode.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }

}
