package com.asgarov.qanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotFoundController {

    @GetMapping("/**")
    public String handle404() {
        return "404";
    }
}
