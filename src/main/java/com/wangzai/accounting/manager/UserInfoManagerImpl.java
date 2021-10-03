package com.wangzai.accounting.manager;

import com.wangzai.accounting.converter.p2cConverter.UserInfoP2CConverter;
import com.wangzai.accounting.dao.UserInfoDAO;
import com.wangzai.accounting.exception.ResourceNotFoundException;
import com.wangzai.accounting.model.DTO.UserInfoDTO;
import com.wangzai.accounting.model.DO.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoManagerImpl implements UserInfoManager{

    private final UserInfoDAO userInfoDAO;
    private final UserInfoP2CConverter userInfoP2CConverter;
    @Autowired
    public UserInfoManagerImpl(UserInfoDAO userInfoDAO, UserInfoP2CConverter userInfoP2CConverter) {
        this.userInfoDAO = userInfoDAO;
        this.userInfoP2CConverter = userInfoP2CConverter;
    }

    @Override
    public UserInfoDTO getUserInfoByUserId(Long userId) {
        UserInfoDO userInfoDO =
                Optional.ofNullable(userInfoDAO.getUserInfoById(userId))
                        .orElseThrow(() -> new ResourceNotFoundException(String.format("Userid = %s not found", userId)));
        return userInfoP2CConverter.convert(userInfoDO);
    }
}
