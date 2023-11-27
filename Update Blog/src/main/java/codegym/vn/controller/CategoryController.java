package codegym.vn.controller;

import codegym.vn.entity.Blog;
import codegym.vn.entity.Category;
import codegym.vn.service.BlogService;
import codegym.vn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("category") Category category) {
        categoryService.create(category);
        return "redirect:/category/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "category/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "category/update";
    }

//    @PostMapping("/update")
//    public String doUpdate(@ModelAttribute("blog") Blog blog) {
//        blog.setCategory(categoryService.findById(blog.getCategory().getCategoryId()));
//        blogService.update(blog);
//        return "redirect:/blog/list";
//    }
}
