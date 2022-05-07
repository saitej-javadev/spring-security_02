package com.saitej.springsecurity_02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String getHome(){
        return "home";
    }
    @GetMapping("/welcome")
    public String getWelcome(){
        return "welcome";
    }
    @GetMapping("/admin")
    public String getAdmin(){
        return "admin";
    }
    @GetMapping("/std")
    public String getStd(){
        return "student";
    }
}
