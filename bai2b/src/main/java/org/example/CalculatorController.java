package com.example.ss2_ex1_calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping(value ="/search")
public class CalculatorController {
    @GetMapping(value ="/cal")
    public String showForm(Model model){
        return "index";
    }
    @PostMapping(value ="/cal")
    public String Calculator(@RequestParam int num1, int num2,String plus,String subtraction,String multiplication,String division,Model model){
        int result = 0;
        if(Objects.equals(plus, "plus"))  {
            result= num1+num2;
            System.out.println(result);
        }
        if(Objects.equals(subtraction, "subtraction")){
            result=num1-num2;
        }
        if(Objects.equals(multiplication, "multiplication")){
            result=num1*num2;
        }
        if(Objects.equals(division, "division")){
            result=num1/num2;
        }
        model.addAttribute("result", result);
        return"index";
    }
}