package com.yunli.girl.controller;

import com.yunli.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

// 使用配置
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;

    //配置分组
    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/say/{id}")
    public String say(@PathVariable("id") Integer id, @RequestParam(value = "name", required = false, defaultValue = "sss") String name) {
        return "id: " + id + "name: " + name + "girl.CupSize " + girlProperties.getCupSize();
//        return girlProperties.getCupSize();
    }
}

