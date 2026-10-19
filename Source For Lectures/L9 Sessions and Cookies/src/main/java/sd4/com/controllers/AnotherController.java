package sd4.com.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnotherController {

    @GetMapping("/another")
    @ResponseBody
    public String index(HttpSession session, Model model) {
        System.out.println(session.getId());
        String output = "username is " + session.getAttribute("username");
        output += "<br>message is " + model.getAttribute("message");
        return output;
    }

}
