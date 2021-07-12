package com.test.cloud.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.cloud.order.entity.Order;
import com.test.cloud.order.entity.OrderItem;

import java.util.List;

public interface IOrderService extends IService<Order> {
    void getOrderById(Long id);

    boolean saveNewOrder(Order order, List<OrderItem> orderItemList);
}
