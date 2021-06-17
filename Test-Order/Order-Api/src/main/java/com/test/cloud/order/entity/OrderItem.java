package com.test.cloud.order.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = -268387550692319883L;

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    private Long orderId;

    private Long productId;
}
