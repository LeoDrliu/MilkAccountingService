package com.wangzai.accounting.converter.p2cConverter;

import com.google.common.base.Converter;
import com.wangzai.accounting.model.DO.UserInfoDO;
import com.wangzai.accounting.model.DTO.UserInfoDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserInfoP2CConverter extends Converter<UserInfoDO, UserInfoDTO> {
    @Override
    protected UserInfoDTO doForward(UserInfoDO userInfoDO) {
        return UserInfoDTO.builder()
                .id(userInfoDO.getId())
                .username(userInfoDO.getUsername())
                .password(userInfoDO.getPassword())
                .build();
    }

    @Override
    protected UserInfoDO doBackward(UserInfoDTO userInfoDTO) {
        return UserInfoDO.builder()
                .id(userInfoDTO.getId())
                .username(userInfoDTO.getUsername())
                .password(userInfoDTO.getPassword())
                .build();
    }
}
