package com.iquest.shoponline.dto.user;

import com.iquest.shoponline.model.Order;

import java.util.Set;

public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Set<Order> orders;


    public UserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDto(String name, String email, Set<Order> orders) {
        this.name = name;
        this.email = email;
        this.orders = orders;
    }

    public UserDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}
