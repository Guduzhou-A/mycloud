package org.gdz.mycloud.common.base.exception;

import lombok.Getter;
import lombok.Setter;
import org.gdz.mycloud.common.base.enums.HttpStatusCode;

@Getter
@Setter
public class BaseException extends Exception {
    private int code;
    private String msg;

    public BaseException(HttpStatusCode httpStatusCode) {
        super(httpStatusCode.msg());
        this.code = httpStatusCode.code();
        this.msg = httpStatusCode.msg();
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseException(int code) {
        this.code = code;
    }

}
