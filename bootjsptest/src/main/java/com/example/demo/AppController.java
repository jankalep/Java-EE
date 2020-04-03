package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String home(){
        return "home";
    }

   @RequestMapping("/new")
    public String New(){
        return "new";
    }
}
