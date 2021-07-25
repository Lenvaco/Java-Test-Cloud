package com.test.cloud.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.cloud.user.dao.UserMapper;
import com.test.cloud.user.entity.User;
import com.test.cloud.user.service.IUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@DubboService(interfaceName = "userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final Logger Logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public boolean debt(Long id, BigDecimal reduceWallet) {
        boolean success = baseMapper.reduceWallet(id, reduceWallet);
        if (success) {
            Logger.info("用户" + id + "减少" + reduceWallet);
        }
        return success;
    }
}
