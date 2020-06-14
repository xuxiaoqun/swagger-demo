package com.xzc.swagger.demo.exception;

import com.xzc.swagger.demo.common.ArgumentInvalidResult;
import com.xzc.swagger.demo.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xzc
 */
@Component
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse exceptionHandler(MethodArgumentNotValidException e) {
        log.error("异常",e);
        List<ArgumentInvalidResult> errorMsg = new ArrayList<>();

        for (FieldError error: e.getBindingResult().getFieldErrors()) {
            ArgumentInvalidResult result = new ArgumentInvalidResult();
            result.setField(error.getField());
            result.setRejectValue(error.getRejectedValue());
            result.setDefaultMsg(error.getDefaultMessage());
            errorMsg.add(result);
        }
         return BaseResponse.builder().code(403).errorMsg(errorMsg).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public BaseResponse exceptionHandler(ConstraintViolationException e) {
        e.printStackTrace();
        return BaseResponse.builder().code(403).msg(e.getLocalizedMessage()).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse exceptionHandler(Exception e) {
        log.error("未定义异常：", e);
        return BaseResponse.builder().code(403).msg("系统开小差了").build();
    }


    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResponse exceptionHandler(BusinessException exception){
        return BaseResponse.builder().code(exception.getResponseCode().getCode()).msg(exception.getMessage()).build();
    }
}