package com.k8s.foo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class FooController {

    @GetMapping
    public String get() {
        return "Hello from Foo " + ZonedDateTime.now();
    }

    @GetMapping("/asd")
    public String asd() {
        return "Foo asd";
    }

}
