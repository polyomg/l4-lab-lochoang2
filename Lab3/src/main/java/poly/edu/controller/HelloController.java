package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
public class HelloController {
    @RequestMapping("/poly/hello")
    public String hello(Model model){
        model.addAttribute("title","FPT Polytechnic");
        model.addAttribute("subject","Hello World");
        return "/poly/hello";
    }
}
