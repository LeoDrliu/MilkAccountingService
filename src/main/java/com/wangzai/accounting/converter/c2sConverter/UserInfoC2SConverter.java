package com.wangzai.accounting.converter.c2sConverter;

import com.google.common.base.Converter;
import com.wangzai.accounting.model.DTO.UserInfoDTO;
import com.wangzai.accounting.model.BO.UserInfoBO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserInfoC2SConverter extends Converter<UserInfoDTO, UserInfoBO> {
    @Override
    protected UserInfoBO doForward(UserInfoDTO userInfoDTO) {
        return UserInfoBO.builder()
                .id(userInfoDTO.getId())
                .username(userInfoDTO.getUsername())
                .build();
    }

    @Override
    protected UserInfoDTO doBackward(UserInfoBO userInfoBO) {
        return UserInfoDTO.builder()
                .id(userInfoBO.getId())
                .username(userInfoBO.getUsername())
                .password(userInfoBO.getPassword())
                .build();
    }
}
