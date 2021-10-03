package com.wangzai.accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: 404 Exception
 * @author: Drliu
 * @date: 2021/8/29
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends ServiceBasicException{
    public InvalidParameterException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.BAD_REQUEST.value());
        this.setErrorCode("Invalid Parameters Entered");
        this.setErrorType(ErrorType.Client);
    }
}
