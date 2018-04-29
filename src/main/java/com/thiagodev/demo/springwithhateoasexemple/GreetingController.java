package com.thiagodev.demo.springwithhateoasexemple;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        greeting.add(linkTo(methodOn(GreetingController.class).allGreeting()).withRel("all"));

        return new ResponseEntity<>(greeting, HttpStatus.OK);

    }

    @RequestMapping("/greeting/")
    public HttpEntity<List<Greeting>> allGreeting() {
        List<Greeting> greetings = new ArrayList<>();

        return new ResponseEntity<>(greetings, HttpStatus.OK);

    }


}
