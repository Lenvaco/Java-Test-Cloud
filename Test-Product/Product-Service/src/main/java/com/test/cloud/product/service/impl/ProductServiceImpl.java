package com.test.cloud.product.service.impl;


import com.test.cloud.product.service.IProductService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class ProductServiceImpl implements IProductService {
    @Override
    public void getProductById(Long id) {
        System.out.println("getProductById");
    }
}
