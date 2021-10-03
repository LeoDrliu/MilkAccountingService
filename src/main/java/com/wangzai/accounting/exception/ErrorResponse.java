package com.wangzai.accounting.exception;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: Drliu
 * @Date: 2021/10/2
 */
@Data
@Builder
public class ErrorResponse {
    private String code;
    private ServiceBasicException.ErrorType errorType;
    private String message;
    private int httpStatus;
}
