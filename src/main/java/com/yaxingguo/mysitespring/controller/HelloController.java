package com.yaxingguo.mysitespring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    @PreAuthorize("hasAnyAuthority('system:test1:list')")
    public String hello(){
        return "hello";
    }
}
