package codegym.vn.controller;

import codegym.vn.entity.User;
import codegym.vn.service.UserService;
import codegym.vn.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidate userValidate;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("user") User user,
                           BindingResult bindingResult, Model model) {
        userValidate.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        userService.create(user);
        return "redirect:/user/list";
    }

//    @GetMapping("/update")
//    public String showUpdate(@RequestParam("id") int id, Model model) {
//        model.addAttribute("user", userService.findById(id));
//
//        return "user/update";
//    }
//
//    @PostMapping("/update")
//    public String doUpdate(@ModelAttribute("user") User user) {
//        userService.update(user);
//        return "redirect:/user/list";
//    }
}
