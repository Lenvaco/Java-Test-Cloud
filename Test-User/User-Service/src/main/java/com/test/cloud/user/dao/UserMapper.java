package com.test.cloud.user.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.cloud.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    boolean reduceWallet(Long id, BigDecimal reduceWallet);
}
