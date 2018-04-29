package com.thiagodev.demo.springwithhateoasexemple;

import org.springframework.hateoas.ResourceSupport;

public class Greeting extends ResourceSupport {

    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
