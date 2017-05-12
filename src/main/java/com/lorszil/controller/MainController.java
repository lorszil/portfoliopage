package com.lorszil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {



    @RequestMapping(value = {"/", "logout"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }


   @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Failed to log in. Email or password is invalid!");
        }
        return "login";
    }

}
