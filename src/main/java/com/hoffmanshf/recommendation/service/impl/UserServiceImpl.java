package com.hoffmanshf.recommendation.service.impl;

import com.hoffmanshf.recommendation.dal.UserModelMapper;
import com.hoffmanshf.recommendation.model.UserModel;
import com.hoffmanshf.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserModelMapper userModelMapper;

    @Autowired
    public UserServiceImpl(UserModelMapper userModelMapper) {
        this.userModelMapper = userModelMapper;
    }

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }
}
