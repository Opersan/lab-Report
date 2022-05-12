package com.example.labreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller
{
    @GetMapping("/")
    public String homePage()
    {
        return "home";
    }
    @GetMapping("/showMyLoginPage")
    public String loginPage()
    {
        return "loginPage";
    }
    @GetMapping("/access-denied")
    public String deniedPage()
    {
        return "access-denied";
    }
}
