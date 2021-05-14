package com.hoffmanshf.recommendation.dal;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "phone number cannot be empty")
    private String phone;
    @NotBlank(message = "password cannot be empty")
    private String password;

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
}
