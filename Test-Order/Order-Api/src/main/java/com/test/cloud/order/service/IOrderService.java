package com.test.cloud.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.cloud.order.entity.Order;

public interface IOrderService extends IService<Order> {
    void getOrderById(Long id);
}
