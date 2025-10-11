package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.product.Product;

@Controller
public class ProductController {
    @GetMapping("/product/form")
    public String form() {
        return "poly/lab2/formbai3";
    }
    @PostMapping("/product/save")
    public String save(Product product, Model model) {
        model.addAttribute("product", product);
        return "poly/lab2/formbai3";
    }
}
