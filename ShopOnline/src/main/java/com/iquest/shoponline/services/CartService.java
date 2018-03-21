package com.iquest.shoponline.services;

import com.iquest.shoponline.dto.cart.CartDto;
import com.iquest.shoponline.dto.cartItem.CartItemDto;
import com.iquest.shoponline.dto.user.UserDto;
import com.iquest.shoponline.model.Cart;
import com.iquest.shoponline.model.CartItem;
import com.iquest.shoponline.repository.CartItemRepository;
import com.iquest.shoponline.repository.CartRepository;
import com.iquest.shoponline.repository.ProductRepository;
import com.iquest.shoponline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    public void updateItemQuantity(Integer quantity, Integer cartId, Integer itemId) {
        CartItem item = cartItemRepository.findByIdAndCartId(itemId, cartId);
        if (item != null) {
            item.setQuantity(quantity);
            cartItemRepository.save(item);
        }
    }

    public void insertProductWith(UserDto user, Integer productId) {
        Cart cart = cartRepository.findFirstCartByUserId(user.getId());
        if (cart == null) {
            cart = new Cart();
            cart.setCreatedDate(new Date());
            cart.setUser(userRepository.findOne(user.getId()));
            cart = cartRepository.save(cart);

            CartItem cartItem = create(productId, cart);
            cartItemRepository.save(cartItem);
        } else {
            CartItem item = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId);
            if (item != null) {
                item.setQuantity(item.getQuantity() + 1);
                cartItemRepository.save(item);
            } else {
                CartItem cartItem = create(productId, cart);
                cartItemRepository.save(cartItem);
            }
        }
    }

    private CartItem create(Integer productId, Cart cart) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(productRepository.findOne(productId));
        cartItem.setQuantity(1);
        return cartItem;
    }

    public CartDto getCartForUser(Integer userId) {
        Cart cart = cartRepository.findFirstCartByUserId(userId);

        if (cart != null) {
            CartDto cartDto = new CartDto();
            cartDto.setId(cart.getId());
            return cartDto;
        }

        return null;
    }

    public void updateUserCart(CartDto cartDto) {
        for (CartItemDto itemDto : cartDto.getItems()) {
            CartItem item = new CartItem();
            item.setId(itemDto.getId());
            item.setQuantity(itemDto.getQuantity());
            item.setProduct(cartItemRepository.findCartItemById(itemDto.getId()).getProduct());
            item.setCart(cartItemRepository.findCartItemById(itemDto.getId()).getCart());
            cartItemRepository.save(item);
        }
    }

    public List<CartItemDto> getCartItemsForUser(Integer userId) {
        List<CartItem> cartItems = cartItemRepository.findAllByCart_UserId(userId);
        List<CartItemDto> dtos = new ArrayList<>();
        cartItems.forEach(item -> populateDto(dtos, item));
        return dtos;
    }

    private void populateDto(List<CartItemDto> dtos, CartItem item) {
        CartItemDto dto = new CartItemDto();
        dto.setId(item.getId());
        dto.setName(productRepository.findNameById(item.getProduct().getId()));
        dto.setPrice(productRepository.findPriceById(item.getProduct().getId()));
        dto.setQuantity(item.getQuantity());
        dtos.add(dto);
    }

    public void deleteItemFromCart(Integer cartId, Integer itemId) {
        cartItemRepository.deleteByIdAndCartId(itemId, cartId);
    }

    public void deleteCart(Integer cartId) {
        cartRepository.delete(cartId);
    }

}
