package com.cfs.SecurityP03.controller;

import com.cfs.SecurityP03.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    AccountServices services;

    @GetMapping("/balance")
    public String getBalance()
    {
        return services.getBalance();
    }

    @PostMapping("/close")
    public String closeAccount()
    {
        return services.closeAccount();
    }

    @GetMapping("/about")
    public String about()
    {
        return "connect, to know more about us";
    }
}
