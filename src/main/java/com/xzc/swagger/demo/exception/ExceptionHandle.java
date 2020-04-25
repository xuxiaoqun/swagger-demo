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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse exceptionHandler(MethodArgumentNotValidException e) {
        log.error("异常",e);
        List<ArgumentInvalidResult> errorMsg = new ArrayList<ArgumentInvalidResult>();

        for (FieldError error: e.getBindingResult().getFieldErrors()) {
            ArgumentInvalidResult result = new ArgumentInvalidResult();
            result.setField(error.getField());
            result.setRejectValue(error.getRejectedValue());
            result.setDefaultMsg(error.getDefaultMessage());
            errorMsg.add(result);
        }
        List<String> list = e.getBindingResult().getFieldErrors().stream().map(message -> message.getDefaultMessage()).collect(Collectors.toList());
        return new BaseResponse(20000,errorMsg);
    }
}
