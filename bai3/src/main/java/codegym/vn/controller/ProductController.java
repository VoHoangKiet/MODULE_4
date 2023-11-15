package codegym.vn.controller;

import codegym.vn.bean.Product;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public String displayList(Model model) {
        model.addAttribute("product", productService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model, Product product) {
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/list";
    }
    @GetMapping("/detail/{id}")
    public String displayDetail2(Model model, @PathVariable("id") String id) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        productService.deleteById(Integer.parseInt(id));
        return "redirect:/list";
    }
}

