package com.example.demo;

import org.springframework.stereotype.Component;

@Component("myBean")
public class GreetingServices {
    public void sayHello(){
        System.out.println("Hello from Spring!");
    }
}
