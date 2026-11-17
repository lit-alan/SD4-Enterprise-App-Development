package com.sd4.L11.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @GetMapping({"/", ""})
    public String index() {
        return "documents/index";
    }

    @PostMapping({"/", ""})
    @ResponseBody
    public String postMethod() {
        return "POSTING";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getDocuments(@PathVariable Integer id) {

        switch (id) {

            case 1:
                return "document1";
            case 2:
                return "document2";
            case 3:
                return "document3";
            default:
                return "failure: no document found";
        }

    }
}
