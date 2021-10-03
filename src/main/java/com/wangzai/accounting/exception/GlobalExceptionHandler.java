package com.wangzai.accounting.exception;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: Drliu
 * @Date: 2021/8/29
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceBasicException.class)
    ResponseEntity<?> handleServiceBasicException(ServiceBasicException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ex.getErrorCode())
                .errorType(ex.getErrorType())
                .message(ex.getMessage())
                .httpStatus(ex.getStatusCode())
                .build();
        return ResponseEntity
                .status(ex.getStatusCode() != 0 ? ex.getStatusCode() : HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(errorResponse);
    }

    // 数据库连接异常
    @ExceptionHandler(CommunicationsException.class)
    ResponseEntity<?> handleServiceBasicException(CommunicationsException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("数据库连接异常")
                .errorType(ServiceBasicException.ErrorType.Service)
                .message(ex.getMessage())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
}
