package com.wangzai.accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description: 404 Exception
 * @Author: Drliu
 * @Date: 2021/8/29
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ServiceBasicException{
    public ResourceNotFoundException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.NOT_FOUND.value());
        this.setErrorCode("Resource Not Found");
        this.setErrorType(ErrorType.Client);
    }
}
