package com.hoffmanshf.recommendation.controller;

import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.common.enums.BusinessError;
import com.hoffmanshf.recommendation.common.CommonResult;
import com.hoffmanshf.recommendation.model.UserModel;
import com.hoffmanshf.recommendation.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/user")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonResult getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if (userModel == null) {
            throw new BusinessException(BusinessError.OBJECT_NOT_FOUND);
        }
        return CommonResult.create(userModel);
    }
}
