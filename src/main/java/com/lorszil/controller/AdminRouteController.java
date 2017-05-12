package com.lorszil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminRouteController {

    @RequestMapping({
            "/admin",
            "/admin/projectedit",
    })
    public String index() {
        return "admin";
    }

}
