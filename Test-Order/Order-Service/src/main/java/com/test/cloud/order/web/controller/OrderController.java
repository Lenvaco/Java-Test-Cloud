package com.test.cloud.order.web.controller;

import com.test.cloud.product.service.IProductService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {
    @DubboReference
    private IProductService productService;
    @GetMapping("/")
    public Object getOrder(){
        System.err.println(productService);
        productService.getProductById(1L);
        return ResponseEntity.ok("111");
    }
}
