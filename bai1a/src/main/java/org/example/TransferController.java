package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping(value = "/money")
public class TransferController {
    @PostMapping(value = "/change")
    public String changeMoney(@RequestParam("money") int money,String  vnd, String usd, Model model){
        System.out.println(vnd);
        if(vnd != null&& usd ==null){
            int  changed= (money / 23000);
            model.addAttribute("changed",changed);
        }if(usd != null && vnd ==null){
            int  changed= (money *  23000);
            model.addAttribute("changed",changed);
        }
        return "index";
    }
    @GetMapping(value = "/change")
    public String showForm(Model model){
        return"index";
    }



}