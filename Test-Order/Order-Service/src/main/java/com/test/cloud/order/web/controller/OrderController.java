package com.test.cloud.order.web.controller;

import com.test.cloud.leaf.id.IDGenService;
import com.test.cloud.leaf.id.common.Result;
import com.test.cloud.order.entity.Order;
import com.test.cloud.order.entity.OrderItem;
import com.test.cloud.order.service.IOrderService;
import com.test.cloud.product.service.IProductService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @DubboReference(lazy = true)
    private IDGenService idGenService;

    @Resource
    private IOrderService orderService;

    @GetMapping(value = "/")
    public Object getOrder(){
        Result result = idGenService.getId("order");
        productService.getProductById(1L);
        return ResponseEntity.ok("ID is" + result.getId());
    }

    @GetMapping(value = "/test")
    public Object queryOrDER(){

        return ResponseEntity.ok("order test");
    }
    @PostMapping("")
    public boolean postNewOrder() {
        Order order = new Order();
        order.setId(idGenService.getId("order").getId());
        List<OrderItem> orderItemList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            OrderItem orderItem = new OrderItem();
            order.setId(idGenService.getId("orderItem").getId());
            orderItem.setOrderId(order.getId());
            orderItemList.add(orderItem);
        }
        order.setOrderCount(orderItemList.size());
        return orderService.saveNewOrder(order, orderItemList);
    }
}
