package com.sd4.L11.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye World";
    }
}
