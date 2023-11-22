package codegym.vn.controller;

import codegym.vn.entity.Blog;
import codegym.vn.service.CommentService;
import codegym.vn.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blog/list";
    }

    @GetMapping("/search")
    public String showSearch(Model model,
                             @RequestParam("blog_name") String name) {
        model.addAttribute("blogs", blogService.findAllByAuthor(name));
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("comments", commentService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {
        blogService.create(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("comments", commentService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        blogService.update(blog);
        return "redirect:/blog/list";
    }
}
