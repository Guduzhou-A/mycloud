package org.gdz.mycloud.common.base.exception;

import org.gdz.mycloud.common.base.enums.BussinessCode;
import org.gdz.mycloud.common.base.enums.HttpStatusCode;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 14:32 2020/6/29 0029
 * @Modified By:
 */
public class BussinessException extends BaseException {

    public BussinessException(BussinessCode bussinessCode) {
        super(bussinessCode.code(), bussinessCode.msg());
    }

    public BussinessException(int code, String msg) {
        super(code, msg);
    }

    public BussinessException(String msg) {
        super(msg);
    }

    public BussinessException(int code) {
        super(code);
    }
}
