package sd4.com.application.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sd4.com.application.model.StudentRegistration;

@Controller
public class StudentController {

    @GetMapping("/students/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute("studentRegistration", new StudentRegistration());

        return "registration";
    }


    @PostMapping("/students/register")
    public String registerStudent(
            @ModelAttribute StudentRegistration registration) {

        System.out.println();
        System.out.println("========== FORM SUBMISSION ==========");
        System.out.println("Name: " + registration.getName());
        System.out.println("Email: " + registration.getEmail());
        System.out.println("Age: " + registration.getAge());
        System.out.println("Student ID: " + registration.getStudentId());
        System.out.println("Course: " + registration.getCourse());
        System.out.println("Password: " + registration.getPassword());
        System.out.println("Confirm Password: " + registration.getConfirmPassword());
        System.out.println("=====================================");
        System.out.println();

        return "registration-success";
    }

//    @PostMapping("/students/register")
//    public String registerStudent(
//            @Valid @ModelAttribute StudentRegistration registration,
//            BindingResult bindingResult,
//            Model model) {
//
//        if (bindingResult.hasErrors()) {
//
//            System.out.println("VALIDATION ERRORS:");
//
//            bindingResult.getAllErrors().forEach(error ->
//                    System.out.println(error.getDefaultMessage())
//            );
//
//            return "registration";
//        }
//
//        System.out.println("========== VALID FORM ==========");
//        System.out.println("Name: " + registration.getName());
//        System.out.println("Email: " + registration.getEmail());
//        System.out.println("Age: " + registration.getAge());
//        System.out.println("Student ID: " + registration.getStudentId());
//        System.out.println("Course: " + registration.getCourse());
//        System.out.println("Password: " + registration.getPassword());
//        System.out.println("Confirm Password: " + registration.getConfirmPassword());
//        System.out.println("================================");
//
//        model.addAttribute("studentRegistration", registration);
//
//        return "registration-success";
//    }
}