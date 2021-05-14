package com.hoffmanshf.recommendation.common;

import com.hoffmanshf.recommendation.common.enums.BusinessError;

public class BusinessException extends Exception {
    private CommonError commonError;

    public BusinessException(BusinessError businessError) {
        super();
        this.commonError = new CommonError(businessError);
    }

    public BusinessException(BusinessError businessError, String errorMessage) {
        super();
        this.commonError = new CommonError(businessError);
        this.commonError.setErrorMessage(errorMessage);
    }

    public CommonError getCommonError() {
        return commonError;
    }

    public void setCommonError(CommonError commonError) {
        this.commonError = commonError;
    }
}
