package com.test.cloud.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.cloud.order.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
