package com.lorszil.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/admin")
@Controller
public class AdminController extends AbstractController {



    @RequestMapping(method = RequestMethod.GET)
    public String mainUI() {
        return "index";
    }


    /*@RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("projects", userService.getAllUsers());
        return "admin/admin_projects";
    }*/

}