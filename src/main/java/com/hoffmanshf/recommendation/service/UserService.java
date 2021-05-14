package com.hoffmanshf.recommendation.service;

import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.model.UserModel;

public interface UserService {
    UserModel getUser(Integer id);

    UserModel register(UserModel user) throws BusinessException;

    UserModel login(String phone,String password) throws BusinessException;

}
