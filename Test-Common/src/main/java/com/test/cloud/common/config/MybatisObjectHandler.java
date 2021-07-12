package com.test.cloud.common.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MybatisObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date currentDateTime = new Date();
        setFieldValByName("createTime", currentDateTime, metaObject);
        setFieldValByName("updateTime", currentDateTime, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(), metaObject);
    }
}
