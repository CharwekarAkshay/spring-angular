package com.coldcoder.springbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    class Greeting {
        private String greeting;

        Greeting(String greeting) {
            this.greeting = greeting;
        }
    }

    @GetMapping("/greeting")
    public Greeting getGreeting() {
        return new Greeting("Hello World");
    }
}
