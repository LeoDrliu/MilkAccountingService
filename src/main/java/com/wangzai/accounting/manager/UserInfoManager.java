package com.wangzai.accounting.manager;

import com.wangzai.accounting.model.DTO.UserInfoDTO;

public interface UserInfoManager {

    public UserInfoDTO getUserInfoByUserId(Long userId);
}
