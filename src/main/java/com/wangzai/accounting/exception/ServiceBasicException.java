package com.wangzai.accounting.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 统一错误异常处理
 * @Author: Drliu
 * @Date: 2021/8/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceBasicException extends RuntimeException {
    private int statusCode;
    private String errorCode;
    private ServiceBasicException.ErrorType errorType;

    public enum ErrorType {
        Client,
        Service,
        Unknown
    }

    public ServiceBasicException(String message) {
        super(message);
    }
}
