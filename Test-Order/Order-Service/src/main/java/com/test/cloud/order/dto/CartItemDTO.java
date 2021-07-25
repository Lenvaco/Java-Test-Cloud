package com.test.cloud.order.dto;


import java.io.Serializable;

public class CartItemDTO implements Serializable {

    private static final long serialVersionUID = 4567979921816566121L;

    private Long productId;

    private Long productQuantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "productId=" + productId +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
