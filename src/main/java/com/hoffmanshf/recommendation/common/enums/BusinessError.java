package com.hoffmanshf.recommendation.common.enums;

public enum BusinessError {

    OBJECT_NOT_FOUND(10001, "OBJECT NOT FOUND"),
    UNKNOWN_ERROR(10002, "UNKNOWN ERROR"),
    ERROR_HANDLER_NOT_FOUND(10003, "PATH NOT FOUND"),
    BIND_EXCEPTION_ERROR(10004, "BIND EXCEPTION ERROR"),
    PARAMETER_VALIDATION_ERROR(10005, "PARAMETER MISSING ERROR"),

    USER_EXISTS_ERROR(20001, "USER ALREADY EXISTS"),
    LOGIN_FAIL(20002,"INCORRECT PHONE NUMBER OR PASSWORD"),

    ADMIN_SHOULD_LOGIN(30001,"ADMIN NEEDS LOGIN");

    private Integer errorCode;
    private String errorMessage;

    BusinessError(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
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
