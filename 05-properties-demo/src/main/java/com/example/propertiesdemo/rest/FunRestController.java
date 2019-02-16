package com.example.propertiesdemo.rest;

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

    // expose a new endpoint for "/workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5K daily for a month";
    }

    // expose a new endpoint for "/fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }
}
