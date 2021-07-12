package com.test.cloud.product.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = -2508749357641160641L;

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    private String title;

    private BigDecimal curPrice;

    private BigDecimal lastPrice;

    private String description;

    private Long inventory;

    private int status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(BigDecimal curPrice) {
        this.curPrice = curPrice;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", curPrice=" + curPrice +
                ", lastPrice=" + lastPrice +
                ", description='" + description + '\'' +
                ", inventory=" + inventory +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
