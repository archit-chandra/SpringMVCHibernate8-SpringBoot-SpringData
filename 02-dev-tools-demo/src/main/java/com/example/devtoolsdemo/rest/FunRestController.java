package com.example.devtoolsdemo.rest;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on the server is: " + LocalDate.now();
    }

}
