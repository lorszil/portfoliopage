
package com.lorszil.controller;


import com.lorszil.model.Project;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.MimeTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);


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


    @RequestMapping(value = "/create_project", method = RequestMethod.POST)
    @ResponseBody
    public String createEvent(@RequestBody String data, Principal principal) throws JSONException {
        JSONObject result = new JSONObject().put("status", "failed");
        Project project = new Project();
        JSONObject json = new JSONObject(data);
        if (validateProjectJson(json)) {
            projectRepository.save(projectFromJson(project, json, principal));
            logger.info("New event created successfully.");
            result.put("status", "success");
        } else {
            logger.error("Invalid json, not all necessary event fields present.");
        }
        return result.toString();
    }

    private boolean validateProjectJson(JSONObject json) {
        logger.info("Validating event json: {}", json);
        List<Field> fields = Arrays.asList(Project.class.getDeclaredFields()).subList(1, 7);
        return !fields.stream().map(field -> json.has(field.getName())).collect(Collectors.toList()).contains(false);
    }

    private Project projectFromJson(Project project, JSONObject json, Principal principal) throws JSONException {
        logger.info("Setting fields of a new event.");
        project.setTitle(json.get("title").toString());
        project.setContent(json.get("content").toString());
        return project;
    }



    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    @ResponseBody
    public String collectProjects(Principal principal) {
        logger.info("/projects route called - method: {}.", RequestMethod.GET);
        JSONObject projects = new JSONObject();
        try {
            projects.put("projects", getAllProjects(principal));
            logger.info("All projects collected to view.");
        } catch (JSONException e) {
            logger.error("{} occurred while collecting projects to json: {}", e.getCause(), e.getMessage());
        }
        return projects.toString();
    }

    private JSONArray getAllProjects(Principal principal) {
        List<Project> projects = projectRepository.findAll();
        logger.info("{} other active events collected.", projects.size());
        return createProjectsJson(projects);
    }

    public JSONArray createProjectsJson(List<Project> projects) {
        JSONArray json = null;
        logger.info("createProjectsJson method called.");
        if (projects.size() > 0) {
            List<JSONObject> js = projects
                    .stream()
                    .map(this::createJsonFromProject)
                    .collect(Collectors.toList());
            json = new JSONArray(js);
        }
        return json;
    }


    public JSONObject createJsonFromProject(Project project) {
        JSONObject json = new JSONObject();
        List<Field> fields = Arrays.asList(Project.class.getDeclaredFields()).subList(1, 2);
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                json.put(field.getName(), field.get(project));
            }
            json.put("title", project.getTitle());
            json.put("content", project.getContent());
            json.put("id", project.getId());
        } catch (JSONException | IllegalAccessException e) {
            logger.error("{} occurred while creating json from project: {}", e.getCause(), e.getMessage());
        }
        return json;
    }


}
