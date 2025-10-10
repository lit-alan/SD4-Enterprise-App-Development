package sd4.com.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm() {
       return "index";
    }

    @PostMapping("/submit")
    public String handleSubmit(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String confirmPassword,
            @RequestParam(required = false) String notes,
            Model model
    ) {
        model.addAttribute("fullName", fullName);
        model.addAttribute("email", email);
        model.addAttribute("age", age);
        model.addAttribute("phone", phone);
        model.addAttribute("password", password);
        model.addAttribute("confirmPassword", confirmPassword);
        model.addAttribute("notes", notes);
        return "result";
    }
}
