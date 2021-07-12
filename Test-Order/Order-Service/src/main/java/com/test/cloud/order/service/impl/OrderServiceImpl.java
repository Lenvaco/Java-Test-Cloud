package com.test.cloud.order.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.cloud.order.entity.Order;
import com.test.cloud.order.dao.OrderMapper;
import com.test.cloud.order.entity.OrderItem;
import com.test.cloud.order.service.IOrderItemService;
import com.test.cloud.order.service.IOrderService;
import com.test.cloud.product.entity.Product;
import com.test.cloud.product.service.IProductService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@DubboService
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    private IOrderItemService orderItemService;

    @DubboReference
    private IProductService productService;

    @Override
    public void getOrderById(Long id) {
        System.out.println("OrderServiceImpl");
    }

    @Override
    public boolean saveNewOrder(Order order, List<OrderItem> orderItemList) {
        if (CollectionUtils.isEmpty(orderItemList)) {
            return false;
        }
        List<Product> productList = productService.listByIds(
                orderItemList.stream()
                    .map(OrderItem::getProductId)
                    .collect(Collectors.toList())
        );
        if (CollectionUtils.isEmpty(productList) || productList.size() != orderItemList.size()) {
            return false;
        }
        List<Product> products = orderItemList.stream().map((orderItems) ->  {
            Product product = new Product();
        }).orElse(Collections.emptyList());
    }
}
