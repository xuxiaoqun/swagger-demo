package com.xzc.swagger.demo.controller;

import com.xzc.swagger.demo.api.TestApi;
import com.xzc.swagger.demo.param.TestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class TestController {

    @GetMapping("/hello")
    public Map<String,Object> hello( @NotBlank String name) {
        Map<String,Object> person = new HashMap(1);
        person.put("name",name);
        return person;
    }

    @PostMapping("/hello1")
    public Map<String, Object> hello1(@RequestBody @Validated TestParam param) {
        Map<String,Object> person = new HashMap<>();
        person.put("name",param.getName());
        person.put("age",param.getAge());
        person.put("sex",param.getSex());
        return person;
    }
}
