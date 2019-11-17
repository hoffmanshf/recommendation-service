package com.hoffmanshf.recommendation.common;

import com.hoffmanshf.recommendation.common.enums.BusinessError;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult handleError(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception exception) {
        if (exception instanceof BusinessException) {
            return CommonResult.create(((BusinessException)exception).getCommonError(), "fail");
        } else if (exception instanceof NoHandlerFoundException) {
            CommonError commonError = new CommonError(BusinessError.ERROR_HANDLER_NOT_FOUND);
            return CommonResult.create(commonError, "fail");
        } else if (exception instanceof ServletRequestBindingException) {
            CommonError commonError = new CommonError(BusinessError.BIND_EXCEPTION_ERROR);
            return CommonResult.create(commonError, "fail");
        } else {
            CommonError commonError = new CommonError(BusinessError.UNKNOWN_ERROR);
            return CommonResult.create(commonError, "fail");
        }
    }
}
