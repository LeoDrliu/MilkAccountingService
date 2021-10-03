package com.wangzai.accounting.controller;

import com.wangzai.accounting.converter.c2sConverter.UserInfoC2SConverter;
import com.wangzai.accounting.exception.InvalidParameterException;
import com.wangzai.accounting.manager.UserInfoManager;
import com.wangzai.accounting.model.BO.UserInfoBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@Slf4j
public class UserController {

    private final UserInfoManager userInfoManager;
    private final UserInfoC2SConverter userInfoC2SConverter;

    @Autowired
    public UserController(UserInfoManager userInfoManager, UserInfoC2SConverter userInfoC2SConverter) {
        this.userInfoManager = userInfoManager;
        this.userInfoC2SConverter = userInfoC2SConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfoBO> getUserInfoByUserId(@PathVariable("id") Long userId) {
        log.info("Get user info by user id {}", userId);
        if (userId == null || userId <= 0L) {
            throw new InvalidParameterException(String.format("The user id %s is invalid", userId));
        }
        UserInfoBO userInfo = userInfoC2SConverter.convert(userInfoManager.getUserInfoByUserId(userId));
        return ResponseEntity.ok(userInfo);
    }
}
