package org.gdz.mycloud.common.base.model;

import org.gdz.mycloud.common.base.enums.BussinessCode;
import org.gdz.mycloud.common.base.enums.HttpStatusCode;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 17:59 2020/6/24 0024
 * @Modified By:
 */
public class ResultBuilder {

    public static Result buildHttpOk() {
        return Result.builder()
                .code(HttpStatusCode.RESPONSE_SUCCESS.code())
                .msg(HttpStatusCode.RESPONSE_SUCCESS.msg())
                .build();
    }

    public static <T> Result<T> buildHttpOk(T data) {
        return (Result<T>) Result.builder()
                .code(HttpStatusCode.RESPONSE_SUCCESS.code())
                .msg(HttpStatusCode.RESPONSE_SUCCESS.msg())
                .data(data)
                .build();
    }

    public static Result buildBussinessOk() {
        return Result.builder()
                .code(BussinessCode.SYSTEM_RESPONSE_SUCCESS.code())
                .msg(BussinessCode.SYSTEM_RESPONSE_SUCCESS.msg())
                .build();
    }

    public static <T> Result<T> buildBussinessOk(T data) {
        return (Result<T>) Result.builder()
                .code(BussinessCode.SYSTEM_RESPONSE_SUCCESS.code())
                .msg(BussinessCode.SYSTEM_RESPONSE_SUCCESS.msg())
                .data(data)
                .build();
    }

    public static Result buildHttpError() {
        return Result.builder()
                .code(HttpStatusCode.RESPONSE_SERVER_EXCEPTION.code())
                .msg(HttpStatusCode.RESPONSE_SERVER_EXCEPTION.msg())
                .build();
    }

    public static Result buildError(int code, String msg) {
        return Result.builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static Result buildHttpError(String msg) {
        return Result.builder()
                .code(HttpStatusCode.RESPONSE_SERVER_EXCEPTION.code())
                .msg(msg)
                .build();
    }

    public static Result buildHttpError(HttpStatusCode httpStatusCode) {
        return Result.builder()
                .code(httpStatusCode.code())
                .msg(httpStatusCode.msg())
                .build();
    }

    public static <T> Result<T> buildHttpError(T data) {
        return (Result<T>) Result.builder()
                .code(HttpStatusCode.RESPONSE_SERVER_EXCEPTION.code())
                .msg(HttpStatusCode.RESPONSE_SERVER_EXCEPTION.msg())
                .data(data)
                .build();
    }

    public static <T> Result<T> buildHttpError(T data, HttpStatusCode httpStatusCode) {
        return (Result<T>) Result.builder()
                .code(httpStatusCode.code())
                .msg(httpStatusCode.msg())
                .data(data)
                .build();
    }

    public static Result buildBussinessError() {
        return Result.builder()
                .code(BussinessCode.SYSTEM_RESPONSE_ERROR.code())
                .msg(BussinessCode.SYSTEM_RESPONSE_ERROR.msg())
                .build();
    }

    public static Result buildBussinessError(String msg) {
        return Result.builder()
                .code(BussinessCode.SYSTEM_RESPONSE_ERROR.code())
                .msg(msg)
                .build();
    }

    public static Result buildBussinessError(BussinessCode bussinessCode) {
        return Result.builder()
                .code(bussinessCode.code())
                .msg(bussinessCode.msg())
                .build();
    }

    public static <T> Result<T> buildBussinessError(T data) {
        return (Result<T>) Result.builder()
                .code(BussinessCode.SYSTEM_RESPONSE_ERROR.code())
                .msg(BussinessCode.SYSTEM_RESPONSE_ERROR.msg())
                .data(data)
                .build();
    }

    public static <T> Result<T> buildBussinessError(T data, BussinessCode bussinessCode) {
        return (Result<T>) Result.builder()
                .code(bussinessCode.code())
                .msg(bussinessCode.msg())
                .data(data)
                .build();
    }

}
