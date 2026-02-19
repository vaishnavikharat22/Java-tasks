package com.cfs.SecurityP02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @GetMapping("/contact")
    public String contactUs(){
        return "Contact Us at: 9851896588";
    }

    @GetMapping("/transfer")
    public String transfer(){
        return "Money transfer successful";
    }

    @GetMapping("/admin")
    public String admin(){
        return "welcome admin";
    }

    @GetMapping("/about")
    public String about()
    {
        return "Genie ashwani founder of Genie Bank";
    }



}

