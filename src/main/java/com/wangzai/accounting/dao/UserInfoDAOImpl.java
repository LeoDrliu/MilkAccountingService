package com.wangzai.accounting.dao;

import com.wangzai.accounting.dao.mapper.UserInfoMapper;
import com.wangzai.accounting.model.DO.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO{

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoDAOImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfoDO getUserInfoById(Long id) {
        return userInfoMapper.getUserInfoByUserId(id);
    }

    @Override
    public void createNewUSer(String userName, String password) {

    }
}
