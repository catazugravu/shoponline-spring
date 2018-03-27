package com.iquest.shoponline.dto.user;

import com.iquest.shoponline.dto.cart.CartDto;

public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private CartDto cartDto;


    public UserDto(String name, String email, String password, CartDto cartDto) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cartDto = cartDto;
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

    public CartDto getCartDto() {
        return cartDto;
    }

    public void setCartDto(CartDto cartDto) {
        this.cartDto = cartDto;
    }


}
