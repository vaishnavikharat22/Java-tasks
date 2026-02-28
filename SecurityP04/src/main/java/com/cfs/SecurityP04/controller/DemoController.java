package com.cfs.SecurityP04.controller;

import com.cfs.SecurityP04.UserListRequest;
import com.cfs.SecurityP04.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private UserService service;

    @GetMapping("/addUsers")
    public String addUsers(@RequestBody UserListRequest request)
    {
        service.saveUsers(request.getUsers());
        return "Users added successfully...";

    }

    @GetMapping("/admin")
    public String adminMethod()
    {
        return "This is admin method";
    }

    @GetMapping("/user")
    public String userMethod()
    {
        return "This is user method";
    }
}

