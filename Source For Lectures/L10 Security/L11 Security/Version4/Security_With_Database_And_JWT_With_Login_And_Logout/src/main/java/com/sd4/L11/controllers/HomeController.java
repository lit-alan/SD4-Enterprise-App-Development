package com.sd4.L11.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HomeController {

    @GetMapping("")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/content")
    @ResponseBody
    public String contentIndex() {
        return "content/index";
    }

    @GetMapping("/content/more")
    @ResponseBody
    public String content() {
        return "content/content1";
    }

    @GetMapping("/content/even-more")
    @ResponseBody
    public String moreContent() {
        return "content/content2";
    }
}