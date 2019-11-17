package com.hoffmanshf.recommendation.common;

public class CommonResult {
    // return status: success or fail
    private String status;
    // if status == success, return json data
    // if status == fail, return error
    private Object data;

    public static CommonResult create(Object result) {
        return CommonResult.create(result, "success");
    }

    public static CommonResult create(Object result, String status) {
        CommonResult commonResult = new CommonResult();
        commonResult.setStatus(status);
        commonResult.setData(result);
        return commonResult;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
