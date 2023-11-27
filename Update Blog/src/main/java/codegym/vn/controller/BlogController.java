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

import java.util.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blog/list";
    }

    @GetMapping("/list_paging")
    public String showListPaging(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.DESC, "price"));
        Page<Blog> blogs = blogService.findAllAndPaging(pageable);
        int totalPage = blogs.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            pageNumbers.add(i + 1);
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumbers", pageNumbers);

        return "blog/list_paging";
    }

    @GetMapping("/list_slice")
    public String showListPagingSlice(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.DESC, "price"));
        Slice<Blog> blogs = blogService.findAllSlice(pageable);
        model.addAttribute("blogs", blogs);
        model.addAttribute("pageSize", pageSize);

        return "blog/list_slice";
    }

    @GetMapping("/search")
    public String showSearch(Model model,
                             @RequestParam("blog_title") String title) {
        model.addAttribute("blogs", blogService.findAllByTitle(title));
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog, @RequestParam("categories") String[] categoriesId) {
//        blog.setCategory(categoryService.findById(blog.getCategories().getCategoryId()));
        Set<Category> categories = new HashSet<>();
        for (String id: categoriesId) {
            categories.add(categoryService.findById(Integer.parseInt(id)));
        }
        blog.setCategories(categories);
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
        model.addAttribute("categories", categoryService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog, @RequestParam("categories") String[] categoriesId) {
//        blog.setCategory(categoryService.findById(blog.getCategory().getCategoryId()));
        Set<Category> categories = new HashSet<>();
        for (String id: categoriesId) {
            categories.add(categoryService.findById(Integer.parseInt(id)));
        }
        blog.setCategories(categories);
        blogService.update(blog);
        return "redirect:/blog/list";
    }
}
