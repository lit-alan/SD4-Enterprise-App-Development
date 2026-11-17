package com.sd4.L11.controllers;


import com.sd4.L11.exceptions.ForbiddenException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")

public class ReportController {

   @GetMapping({"", "/"})
    public String index() {
            return "reports/index";
    }

   @PostMapping ({"", "/"})
   public String doIt() {
        return "reports/index";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getReports(@PathVariable Integer id) {

        switch (id) {

            case 1:
                return "reports1";
            case 2:
                return "reports2";
            case 3:
                return "reports3";
            default:
                return "failure: no report found";
        }
    }
}
