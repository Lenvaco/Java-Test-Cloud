package com.test.cloud.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.cloud.order.entity.Order;
import com.test.cloud.order.dao.OrderMapper;
import com.test.cloud.order.service.IOrderService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;


@Service
@DubboService
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Override
    public void getOrderById(Long id) {
        System.out.println("OrderServiceImpl");
    }
}
