package com.lorszil.controller;

import com.lorszil.model.User;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class UserController {


/*    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(@RequestBody String data, Principal user) throws JSONException {
        JSONObject jsonData = new JSONObject(data);
        return jsonData.toString();
    }*/


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String user(Principal user) throws IllegalAccessException {
        JSONObject jsonObject = new JSONObject();
        String userName = user.getName();
        try {
            jsonObject.put("name", userName);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jsonObject.toString();
    }

}
