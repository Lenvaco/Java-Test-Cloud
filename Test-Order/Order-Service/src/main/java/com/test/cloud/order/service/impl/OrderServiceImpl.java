package com.test.cloud.order.service.impl;

import com.test.cloud.order.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
    @Override
    public void getOrderById(Long id) {
        System.out.println("OrderServiceImpl");
    }
}
