package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/calculate")
    public double calculateR(@RequestParam double x, @RequestParam double a) {
        double y = 1.999999;
        double m = (x + y) / 3;
        double R = 3 * Math.pow(y, 3) + (Math.pow(a, 2) / Math.sqrt(m)) * ((2 * x) / (2 * y));
        return R;
    }
}
