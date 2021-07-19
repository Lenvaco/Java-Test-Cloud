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
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
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

    @GlobalTransactional
    @Override
    public boolean saveNewOrder(Order order, List<OrderItem> orderItemList) {
        if (CollectionUtils.isEmpty(orderItemList)) {
            return false;
        }
        // 获取订单的所有商品
        List<Product> productList = productService.listByIds(
                orderItemList.stream()
                    .map(OrderItem::getProductId)
                    .collect(Collectors.toList())
        );
        if (CollectionUtils.isEmpty(productList) || productList.size() != orderItemList.size()) {
            return false;
        }
        final BigDecimal[] totalPrice = {BigDecimal.ZERO};
        // 更新商品的状态
        List<Product> products = orderItemList.stream().map((orderItems) ->  {
            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                if (product.getId().equals(orderItems.getProductId())) {
                    totalPrice[0] = totalPrice[0].add(product.getCurPrice().multiply(new BigDecimal(orderItems.getItemCount())));
                    product.setInventory(product.getInventory() - orderItems.getItemCount());
                    return product;
                }
            }
            return null;
        }).collect(Collectors.toList());
        System.err.println(products.toString());
        // 商品库存
        productService.updateBatchById(products);
        // 保存订单
        boolean save = save(order);
        if(save) {
            throw  new RuntimeException("假设出现异常");
        }
        //保存订单项
        orderItemService.saveBatch(orderItemList);
        return true;
    }
}
