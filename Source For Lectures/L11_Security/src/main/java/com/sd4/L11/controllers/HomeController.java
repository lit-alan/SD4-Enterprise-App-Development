package com.sd4.L11.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

@Autowired
private String greetingMessage;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/content")
    @ResponseBody
    public String contentIndex() {
        return "content/index " +greetingMessage ;
    }

    @GetMapping("/content/more")
    public String content() {
        return "content/content1";
    }
    @GetMapping("/content/even-more")
    public String moreContent() {
        return "content/content2";
    }

//    @GetMapping("/content")
//    public String contentIndex(HttpSession sess) {
//        sess.setAttribute("uname", getLoggedInName());
//        System.out.println("User Name: " + getLoggedInName());
//        return "content/index";
//    }

//    private String getLoggedInName() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return ((UserDetails)principal).getUsername();
//    }


}

