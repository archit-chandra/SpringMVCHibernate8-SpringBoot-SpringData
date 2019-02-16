package com.example.propertiesdemo.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

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

    // expose new endpoint for team info (coachName + teamName)
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }
}
