package com.test.cloud.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.cloud.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
