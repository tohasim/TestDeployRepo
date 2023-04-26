package com.example.test.Controllers;

import com.example.test.Repo.Repo;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("Test")
public class TestController {
    private Repo database;
    public TestController(ApplicationContext context, @Value("${Test.repository.impl}") String impl) {
        this.database = (Repo) context.getBean(impl);
    }

    @GetMapping("/")
    public String welcome(Model model){
        List<String> messages = database.getAllMessages();
        model.addAttribute("messages", messages);
        return "hello";
    }
}
