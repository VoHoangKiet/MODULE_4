package org.example.controller;

import org.example.entity.Song;
import org.example.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongRepository songRepository;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "song/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("song", new Song());
        return "song/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("song") Song song) {
        songRepository.create(song);
        return "redirect:/song/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Song song = songRepository.findById(id);
        model.addAttribute("song", song);
        return "song/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("song", songRepository.findById(id));
        return "song/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("song") Song song) {
        songRepository.update(song);
        return "redirect:/song/list";
    }
}
