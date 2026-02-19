package com.example.demo;

import com.example.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        GreetingServices greetingServices = (GreetingServices) context.getBean("myBean");
//        greetingServices.sayHello();
//
//        UserService userService  = (UserService) context.getBean("UserServiceSMS");
//        userService.notifyUser("Whatsuppp user!");

//        UserService userServiceEmail  = (UserService) context.getBean("UserServiceEmail");
//        userServiceEmail.notifyUser("Whatsuppp user!");

          System.out.println("Starting Spring Application Context");
          ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

          System.out.println("Retrieving Lifecycle Beans");
          LifecycleBean lifecycleBean = context.getBean(LifecycleBean.class);

          lifecycleBean.performTask();

          System.out.println("Closing Spring Context");
    }
}
