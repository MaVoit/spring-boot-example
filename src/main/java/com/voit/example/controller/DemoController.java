package com.voit.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mark voit
 */
@RestController
public class DemoController {

    @RequestMapping("/")
    String home() {
        return "Hello from Demo App!";
    }
}
