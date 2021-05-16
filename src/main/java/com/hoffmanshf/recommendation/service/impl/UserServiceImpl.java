package com.hoffmanshf.recommendation.service.impl;

import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.common.enums.BusinessError;
import com.hoffmanshf.recommendation.dal.UserModelMapper;
import com.hoffmanshf.recommendation.model.UserModel;
import com.hoffmanshf.recommendation.service.UserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final UserModelMapper userModelMapper;

    public UserServiceImpl(UserModelMapper userModelMapper) {
        this.userModelMapper = userModelMapper;
    }

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    // commit transactions in this method if success, otherwise rollback
    public UserModel register(UserModel user) throws BusinessException {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        try {
            userModelMapper.insertSelective(user);
        } catch (DuplicateKeyException ex) {
            throw new BusinessException(BusinessError.USER_EXISTS_ERROR);
        }
        return getUser(user.getId());
    }

    @Override
    public UserModel login(String phone, String password) throws BusinessException {
        UserModel userModel = userModelMapper.selectByPhoneAndPassword(phone, password);
        if (userModel == null) {
            throw new BusinessException(BusinessError.LOGIN_FAIL);
        }
        return userModel;
    }

    @Override
    public Integer countAllUser() {
        return userModelMapper.countAllUser();
    }
}
