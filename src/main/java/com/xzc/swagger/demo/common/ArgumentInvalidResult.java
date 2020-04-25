package com.xzc.swagger.demo.common;

import lombok.Data;

@Data
public class ArgumentInvalidResult {
    private String field;
    private Object rejectValue;
    private String defaultMsg;
}
