package com.hoffmanshf.recommendation.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ShopCreateRequest {
    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotNull(message = "pricePerMan cannot be null")
    private Integer pricePerMan;

    @NotNull(message = "latitude cannot be null")
    private BigDecimal latitude;

    @NotNull(message = "longitude cannot be null")
    private BigDecimal longitude;

    @NotNull(message = "categoryId cannot be null")
    private Integer categoryId;

    private String tags;

    @NotBlank(message = "startTime cannot be empty")
    private String startTime;

    @NotBlank(message = "endTime cannot be empty")
    private String endTime;

    @NotBlank(message = "address cannot be empty")
    private String address;

    @NotNull(message = "sellerId cannot be null")
    private Integer sellerId;

    @NotBlank(message = "iconUrl cannot be empty")
    private String iconUrl;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPricePerMan() {
        return pricePerMan;
    }

    public void setPricePerMan(Integer pricePerMan) {
        this.pricePerMan = pricePerMan;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
