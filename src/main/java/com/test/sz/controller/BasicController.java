package com.test.sz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BasicController {

    @GetMapping("/hello_world/{id}")
    public Mono<String> sayHelloWorld(@PathVariable("id") final String id) {
        return Mono.just(id);
    }
}