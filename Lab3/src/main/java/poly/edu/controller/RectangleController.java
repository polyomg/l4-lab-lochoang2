package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RectangleController {

    @Autowired
    HttpServletRequest request;
    @GetMapping("/rectangle/form")
    public String form() {
        return "poly/rectangle";
    }
    @PostMapping("/rectangle/calc")
    public String calc(Model model) {


        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));

        double area = length * width;
        double perimeter = 2 * (length + width);
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("length", length);
        model.addAttribute("width", width);
        if(length > width) {
            model.addAttribute("Không đổi");
        } else {
            double t = length;
            length = width;
            width = t;
        }
        return "poly/rectangle";
    }
}
