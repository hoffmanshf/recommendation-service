package com.hoffmanshf.recommendation.common;

import com.hoffmanshf.recommendation.common.enums.BusinessError;

public class CommonError {
    private Integer errorCode;
    private String errorMessage;

    public CommonError(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CommonError(BusinessError businessError) {
        this.errorCode = businessError.getErrorCode();
        this.errorMessage = businessError.getErrorMessage();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
