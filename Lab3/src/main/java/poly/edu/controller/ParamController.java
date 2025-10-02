package poly.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParamController {

    @RequestMapping("/param/form")
    public String form() {
        return "poly/formlab2";
    }

    @RequestMapping(value = "/param/save/{x}", method = RequestMethod.POST)
    public String save(
            @PathVariable("x") String x,
            @RequestParam("y") String y,
            Model model ) {

        model.addAttribute("x", x);
        model.addAttribute("y", y);

        return "poly/formlab2";
    }
}
