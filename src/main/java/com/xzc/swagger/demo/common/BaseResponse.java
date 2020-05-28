package com.xzc.swagger.demo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author xzc
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private Integer code;
    private String msg;
    private List<ArgumentInvalidResult> errorMsg;

}
