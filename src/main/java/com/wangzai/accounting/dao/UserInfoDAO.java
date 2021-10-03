package com.wangzai.accounting.dao;

import com.wangzai.accounting.model.DO.UserInfoDO;

public interface UserInfoDAO {

    UserInfoDO getUserInfoById(Long id);

    void createNewUSer(String userName, String password);
}
