package com.test.cloud.product.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.cloud.product.dao.ProductMapper;
import com.test.cloud.product.entity.Product;
import com.test.cloud.product.service.IProductService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Override
    public void getProductById(Long id) {
        System.out.println("getProductById");
    }
}
