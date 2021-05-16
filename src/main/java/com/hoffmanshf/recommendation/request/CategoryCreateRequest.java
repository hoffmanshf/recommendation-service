package com.hoffmanshf.recommendation.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoryCreateRequest {
    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotBlank(message = "iconUrl cannot be empty")
    private String iconUrl;

    @NotNull(message = "sort cannot be null")
    private Integer sort;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
