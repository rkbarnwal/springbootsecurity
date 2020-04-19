package com.rkb.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    String greeting(Principal principal) {
        return String.format("Hello %s", principal.getName());
    }
}
