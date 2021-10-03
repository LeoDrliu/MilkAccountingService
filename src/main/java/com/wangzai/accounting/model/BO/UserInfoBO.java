package com.wangzai.accounting.model.BO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoBO {
    private Long id;
    private String username;
    private String password;
}
