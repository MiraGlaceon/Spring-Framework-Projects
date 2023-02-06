package mira.space.restfulwebservice.controller;

import mira.space.restfulwebservice.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting get(@RequestParam(value = "name", defaultValue = "Viewer") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
