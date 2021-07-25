package com.test.cloud.user.web.controller;


import com.test.cloud.leaf.id.IDGenService;
import com.test.cloud.user.entity.User;
import com.test.cloud.user.service.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RequestMapping("/user")
@RestController
public class UserController {

    @DubboReference(lazy = true)
    private IDGenService idGenService;

    @Resource
    private IUserService userService;

    @PostMapping("/")
    public boolean registerUser() {
        User user = new User();
        user.setId(idGenService.getId("user").getId());
        user.setNickName("Lenvaco");
        user.setAccount("1156434215");
        user.setPassword("123456");
        user.setWallet(new BigDecimal("1000000"));
        return userService.save(user);
    }
}
