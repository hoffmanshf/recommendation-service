package com.hoffmanshf.recommendation.request;

import javax.validation.constraints.NotBlank;

public class RegisterRequest {
    @NotBlank(message = "phone number cannot be empty")
    private String phone;

    @NotBlank(message = "password cannot be empty")
    private String password;

    @NotBlank(message = "nickName cannot be empty")
    private String nickName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
