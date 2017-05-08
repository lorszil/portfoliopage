package com.lorszil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class BlogController {

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
