package com.test.cloud.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = -2508749357641160641L;

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    
}
