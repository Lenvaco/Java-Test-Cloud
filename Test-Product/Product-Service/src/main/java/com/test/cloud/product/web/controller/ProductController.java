package com.test.cloud.product.web.controller;

import com.test.cloud.leaf.id.IDGenService;
import com.test.cloud.product.entity.Product;
import com.test.cloud.product.service.IProductService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RequestMapping("/product")
@RestController
public class ProductController {

    @DubboReference(lazy = true)
    private IDGenService idGenService;

    @Resource
    private IProductService productService;

    @PostMapping("")
    public boolean saveNewProduct() {
        Product product = new Product();
        product.setId(idGenService.getId("product").getId());
        product.setTitle("商品标题");
        product.setCurPrice(new BigDecimal("1000"));
        product.setLastPrice(new BigDecimal("1200"));
        product.setDescription("商品描述");
        product.setInventory(1000L);
        product.setStatus(0);
        return productService.saveProduct(product);
    }
}
