package com.test.controller;


import com.test.pojo.Result;
import com.test.pojo.User;
import com.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result getOneByAandP(@RequestBody User user){
        log.info("使用者登入:{}",user);
        User u = userService.login(user);

        if (u!=null){
            Map<String,Object> userInfo = new HashMap<>();
            userInfo.put("EMP_ID",u.getEmpId());
            userInfo.put("EMP_NAME",u.getEmpName());
            return Result.success(userInfo);
        }else {
            return Result.error("帳號或密碼錯誤");}


    }
}