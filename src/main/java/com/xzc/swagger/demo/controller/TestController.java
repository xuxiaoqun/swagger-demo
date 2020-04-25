package com.xzc.swagger.demo.controller;

import com.xzc.swagger.demo.api.TestApi;
import com.xzc.swagger.demo.param.TestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController implements TestApi {

    @Override
    public Map<String,Object> hello(String name, String age) {
        Map<String,Object> person = new HashMap<>();
        person.put("name",name);
        person.put("age",age);
        return person;
    }

    @Override
    public Map<String, Object> hello1(@RequestBody @Validated TestParam param) {

        Map<String,Object> person = new HashMap<>();
        person.put("name",param.getName());
        person.put("age",param.getAge());
        person.put("sex",param.getSex());
        return person;
    }
}
