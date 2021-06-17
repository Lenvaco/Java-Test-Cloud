package com.test.cloud.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.cloud.order.entity.OrderItem;
import com.test.cloud.order.dao.OrderItemMapper;
import com.test.cloud.order.service.IOrderItemService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {
}
