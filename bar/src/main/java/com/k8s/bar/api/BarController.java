package com.k8s.bar.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class BarController {

    @GetMapping
    public String get() {
        return "Hello from Bar " + ZonedDateTime.now();
    }

    @GetMapping("/asd")
    public String asd() {
        return "Bar asd";
    }
}
