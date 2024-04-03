package com.test.mapper;

import com.test.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    //根據帳號及密碼檢核使用者登入
    @Select("select * from employee where account=#{account} and password=#{password}")
    User getUserByAandP(User user);

    @Select("select * from employee where emp_id !=1")
    List<User> getEmpInfo();

    @Insert("INSERT INTO employee (account,password,emp_name) VALUES (#{account}, #{password}, #{empName});")
    void insertEmp(User user);
}
