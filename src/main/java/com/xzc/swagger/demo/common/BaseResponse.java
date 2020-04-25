package com.xzc.swagger.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class BaseResponse {
    private Integer code;
    private List<ArgumentInvalidResult> errorMsg;

}
