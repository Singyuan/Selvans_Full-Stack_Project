package com.test.mapper;

import com.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //根據帳號及密碼檢核使用者登入
    @Select("select * from employee where account=#{account} and password=#{password}")
    User getUserByAandP(User user);
}
