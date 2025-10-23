package poly.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.product.Product;

import java.util.Arrays;
import java.util.List;

@Controller
public class Product4Controller {
    @GetMapping("/product4/form")
    public String form(Model  model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p1", p);
        return "poly/lab2/formbai4";
    }

    @PostMapping("/product4/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        Product p1 = new Product("iPhone 30", 5000.0);
        model.addAttribute("p1", p1);

        return "poly/lab2/formbai4";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(new Product("A", 1.0), new Product("B", 12.0));
    }
}
