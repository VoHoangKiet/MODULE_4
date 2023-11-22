package org.example.controller;

import org.example.entity.Comment;
import org.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("comments", commentRepository.findAll());
        return "comment/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("comment") Comment comment) {
        commentRepository.create(comment);
        return "redirect:/comment/list";
    }
}
