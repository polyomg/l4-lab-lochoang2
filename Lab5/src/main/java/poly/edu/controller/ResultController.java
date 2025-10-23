package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poly.edu.product.Product;

import java.util.Arrays;
import java.util.List;

@Controller
public class ResultController {
    @RequestMapping("/a")
    public String m1() {
        return "poly/a";
    }
    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a";
    }
    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";
    }

    @ResponseBody
    @RequestMapping("/d")
    public String m4() {
        return "I come from d";
    }
}
