package com.zander404.msticketmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TicketController {
    @GetMapping
    public String test() {
        return "test";
    }
}

