package com.wangzai.accounting.dao.mapper;

import com.wangzai.accounting.model.DO.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("SELECT id, username, password, create_time, update_time FROM milk_userinfo WHERE id = #{id}")
    UserInfoDO getUserInfoByUserId(@Param("id") Long id);
}
