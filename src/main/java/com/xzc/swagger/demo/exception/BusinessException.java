package com.xzc.swagger.demo.exception;

import com.xzc.swagger.demo.common.ResponseCodeEnum;
import lombok.Data;

/**
 * @author xuzhicheng
 * @Description: 定义业务异常类
 * @date 2020/6/1415:58
 */
@Data
public class BusinessException extends RuntimeException{
    private ResponseCodeEnum responseCode;

    public BusinessException(ResponseCodeEnum errorCode, String errorMessage) {
        super(errorMessage);
        this.setResponseCode(errorCode);
    }
}
