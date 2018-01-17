package com.iquest.ShopOnline.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    protected Order() {
    }

    public Order(Integer userId, String deliveryAddress, Date orderDate) {
        this.userId = userId;
        this.deliveryAddress = deliveryAddress;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
