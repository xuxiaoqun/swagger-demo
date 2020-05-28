package com.xzc.swagger.demo.controller;

import com.google.common.collect.Maps;
import com.xzc.swagger.demo.param.TestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * @author xzc
 */
@RestController
@Validated
public class TestController {

    @GetMapping("/hello")
    public Map<String,Object> hello( @NotBlank String name) {
        Map<String,Object> person = Maps.newHashMapWithExpectedSize(1);
        person.put("name",name);
        return person;
    }

    @PostMapping("/hello1")
    public Map<String, Object> hello1(@RequestBody @Validated TestParam param) {
        Map<String,Object> person = Maps.newHashMapWithExpectedSize(1);
        person.put("name",param.getName());
        person.put("age",param.getAge());
        person.put("sex",param.getSex());
        return person;
    }
}
