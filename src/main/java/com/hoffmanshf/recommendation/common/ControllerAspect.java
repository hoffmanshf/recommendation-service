package com.hoffmanshf.recommendation.common;

import com.hoffmanshf.recommendation.common.enums.BusinessError;
import com.hoffmanshf.recommendation.controller.admin.AdminController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Aspect
@Configuration
public class ControllerAspect {

    private final HttpServletRequest httpServletRequest;

    private final HttpServletResponse httpServletResponse;

    public ControllerAspect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
    }

    @Around("execution(* com.hoffmanshf.recommendation.controller.admin.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object adminControllerBeforeValidation(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AdminPermission adminPermission = method.getAnnotation(AdminPermission.class);
        if (adminPermission == null) {
            // public endpoint, do nothing
            Object resultObject = joinPoint.proceed();
            return resultObject;
        }
        String email = (String) httpServletRequest.getSession().getAttribute(AdminController.CURRENT_ADMIN_SESSION);
        if (email == null) {
            if (adminPermission.produceType().equals("text/html")) {
                httpServletResponse.sendRedirect("/admin/admin/loginpage");
                return null;
            } else {
                CommonError commonError = new CommonError(BusinessError.ADMIN_SHOULD_LOGIN);
                return CommonResult.create(commonError, "fail");
            }

        } else {
            Object resultObject = joinPoint.proceed();
            return resultObject;
        }
    }
}

