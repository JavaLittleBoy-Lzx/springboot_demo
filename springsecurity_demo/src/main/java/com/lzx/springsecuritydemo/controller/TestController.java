package com.lzx.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author lzx
 * @Date 2023/7/29 8:08:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello,security";
    }

    @GetMapping("index")
    public String index() {
        return "hello,index";
    }

    @PostMapping("/success")
    public String success() {
        return "success";
    }
}
