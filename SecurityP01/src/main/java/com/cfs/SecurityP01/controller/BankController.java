package com.cfs.SecurityP01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    int bal = 1000;

    @GetMapping("/bal")
    public int getBalance(){
        return bal;
    }

    @PostMapping("/add")
    public int updateBalance(@RequestParam String AcctNo, @RequestParam int num){

        return bal + num;
    }

    @GetMapping("/contact")
    private String contactUs()
    {
        return "you can contact us at: 9855245121";
    }

}
