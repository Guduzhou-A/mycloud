package org.gdz.mycloud.common.base.model;

import lombok.Builder;
import lombok.Data;
import org.gdz.mycloud.common.base.enums.BussinessCode;
import org.gdz.mycloud.common.base.enums.HttpStatusCode;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 *
 * @author guduz
 */
@Data
@Builder
public class Result<T> implements Serializable {

    private int code;
    private String msg;
    private T data;
    private boolean success;

    public boolean isSuccess() {
        if (code == HttpStatusCode.RESPONSE_SUCCESS.code() || code == BussinessCode.SYSTEM_RESPONSE_SUCCESS.code()) {
            return true;
        }
        return false;
    }
}