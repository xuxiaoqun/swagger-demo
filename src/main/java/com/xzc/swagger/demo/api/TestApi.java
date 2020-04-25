package com.xzc.swagger.demo.api;

import com.xzc.swagger.demo.param.TestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Api(tags = "test_swagger")
@RequestMapping("/api/swagger/api")
public interface TestApi {
    @ApiOperation(value = "测试swagger" )
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string" ,value = "姓名", name = "name",paramType = "query"),
            @ApiImplicitParam(dataType = "string", value = "年龄", name = "age",paramType = "query")
    })
    @GetMapping("/hello")
    public Map<String,Object> hello(String name, String age);

    @ApiOperation(value = "测试swagger" )
    @PostMapping("/hello1")
    public Map<String,Object> hello1(@RequestBody TestParam param);
}
