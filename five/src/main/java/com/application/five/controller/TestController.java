package com.application.five.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welocome")
public class TestController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }
}
