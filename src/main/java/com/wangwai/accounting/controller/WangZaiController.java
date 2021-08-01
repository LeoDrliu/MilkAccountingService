package com.wangwai.accounting.controller;

import com.wangwai.accounting.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WangZaiController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path = "v1/wangwang")
    public Greeting sayHello (@RequestParam("name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("%s",name));
    }
}
