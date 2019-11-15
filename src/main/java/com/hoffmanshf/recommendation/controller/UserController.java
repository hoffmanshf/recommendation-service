package com.hoffmanshf.recommendation.controller;

import com.hoffmanshf.recommendation.model.UserModel;
import com.hoffmanshf.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("get")
    @ResponseBody
    public UserModel getUser(@RequestParam(name = "id") Integer id) {
        return userService.getUser(id);
    }
}
