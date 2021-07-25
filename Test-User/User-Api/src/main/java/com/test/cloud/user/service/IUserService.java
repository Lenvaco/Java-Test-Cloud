package com.test.cloud.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.test.cloud.user.entity.User;

import java.math.BigDecimal;

public interface IUserService extends IService<User> {
    boolean debt(Long id, BigDecimal reduceWallet);
}
