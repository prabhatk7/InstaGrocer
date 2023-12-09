package com.instagrocer.inventory;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    // private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/item")
    public Item greeting(@RequestParam(value="name", defaultValue = "Potato") String name) {
        return new Item(counter.incrementAndGet(), name);
    }
}
