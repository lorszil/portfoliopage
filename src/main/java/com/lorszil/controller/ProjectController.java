
package com.lorszil.controller;


import com.lorszil.model.Project;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.MimeTable;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ProjectController extends AbstractController {


    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    /*@RequestMapping(value = "/admin/create_project", method = RequestMethod.POST)
    @ResponseBody
    public String createProject(@RequestBody String data, Principal principal) throws JSONException {
        JSONObject result = new JSONObject().put("status", "failed");
        Project project = new Project();
        JSONObject json = new JSONObject(data);
        if (validateProjectJson(json)) {

            project.setTitle(json.get("name").toString());
            project.setContent(json.get("description").toString());

            projectRepository.save(project);
            result.put("status", "success");
        }
        return result.toString();
    }*/

    /*private boolean validateProjectJson(JSONObject json) {
        List<Field> fields = Arrays.asList(Project.class.getDeclaredFields()).subList(1, 2);
        return !fields.stream().map(field -> json.has(field.getName())).collect(Collectors.toList()).contains(false);
    }*/

}
