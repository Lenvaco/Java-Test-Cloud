package com.test.cloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.cloud.product.entity.Product;

public interface IProductService extends IService<Product> {
    void getProductById(Long id);
}
