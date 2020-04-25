package com.xzc.swagger.demo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class TestParam {

    @NotEmpty(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名")
    private String name;

    @Min(value = 18 ,message = "未满18岁")
    @Max(value = 60, message = "超过60岁")
    @ApiModelProperty(value = "年龄")
    private int age;


    @ApiModelProperty(value = "性别")
    private String sex;


}
