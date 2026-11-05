package com.sd4.L11.controllers;

import com.sd4.L11.service.PasswordHashingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class PasswordHashingController {

    @Autowired
    private PasswordHashingService passwordHashingService;

    @GetMapping("/hash-passwords")
    @ResponseBody
    public String hashPasswords() {
        passwordHashingService.hashExistingPasswords();
        return "Passwords hashed successfully.";
    }
}


eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhb2lmZV9tdXJwaHk3OEBnbWFpbC5jb20iLCJpYXQiOjE3NjI0NDM2MTcsImV4cCI6MTc2MjQ3OTYxN30.M7q3O-4ED1-ZDvoT2CwAbuDED1kNPg9VJQull7JICIU