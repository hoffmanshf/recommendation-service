package com.hoffmanshf.recommendation.controller;

import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.common.CommonUtil;
import com.hoffmanshf.recommendation.common.enums.BusinessError;
import com.hoffmanshf.recommendation.common.CommonResult;
import com.hoffmanshf.recommendation.request.LoginRequest;
import com.hoffmanshf.recommendation.model.UserModel;
import com.hoffmanshf.recommendation.request.RegisterRequest;
import com.hoffmanshf.recommendation.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller("/user")
@RequestMapping("/user")
public class UserController {

    public static final String CURRENT_USER_SESSION = "currentUserSession";

    private final UserService userService;

    private final HttpServletRequest httpServletRequest;

    public UserController(UserService userService, HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.httpServletRequest = httpServletRequest;
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

    @RequestMapping("/register")
    @ResponseBody
    public CommonResult register(@Valid @RequestBody RegisterRequest registerRequest, BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        UserModel newUser = new UserModel();
        newUser.setPhone(registerRequest.getPhone());
        newUser.setPassword(registerRequest.getPassword());
        newUser.setNickName(registerRequest.getNickName());
        UserModel res = userService.register(newUser);
        return CommonResult.create(res);
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestBody @Valid LoginRequest loginReq, BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        UserModel userModel = userService.login(loginReq.getPhone(), loginReq.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION, userModel);
        return CommonResult.create(userModel);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public CommonResult logout() {
        httpServletRequest.getSession().invalidate();
        return CommonResult.create(null);
    }

    @RequestMapping("/getcurrentuser")
    @ResponseBody
    public CommonResult getCurrentUser() {
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return CommonResult.create(userModel);
    }
}
