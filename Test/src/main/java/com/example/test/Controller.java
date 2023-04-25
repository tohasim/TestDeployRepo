package com.example.test;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("Test")
@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String welcome(Model model){
        return "hello";
    }
}
