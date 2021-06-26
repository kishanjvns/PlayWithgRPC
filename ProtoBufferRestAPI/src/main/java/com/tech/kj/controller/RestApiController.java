package com.tech.kj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestApiController {

    @RequestMapping("/")
    public String greeting(){
        return "Hi good evening";
    }
}