package com.iquest.shoponline.services;

import com.iquest.shoponline.dto.cart.CartDto;
import com.iquest.shoponline.dto.cartItem.CartItemDto;
import com.iquest.shoponline.dto.user.UserDto;
import com.iquest.shoponline.model.Cart;
import com.iquest.shoponline.model.CartItem;
import com.iquest.shoponline.model.Product;
import com.iquest.shoponline.model.User;
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

    public void updateItemQuantityFor(CartDto cart, Integer productId, Integer quantity) {
        for (CartItemDto item : cart.getItems()) {
            if (item.getProductId() == productId) {
                item.setQuantity(quantity);
            }
        }
    }

    public void addCartItemTo(CartDto cart, Integer productId) {
        Product product = productRepository.findFirstById(productId);

        for (CartItemDto item : cart.getItems()) {
            if (item.getProductId() == product.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }

        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setName(product.getName());
        cartItemDto.setPrice(product.getPrice());
        cartItemDto.setQuantity(1);
        cartItemDto.setProductId(product.getId());
        cart.addItem(cartItemDto);
    }

    public CartDto getCartForUser(Integer userId) {
        Cart cart = cartRepository.findFirstCartByUserId(userId);

        if (cart != null) {
            CartDto cartDto = new CartDto();
            cartDto.setId(cart.getId());

            List<CartItemDto> cartItemList = new ArrayList<>();
            for (CartItem item : cart.getItems()) {
                CartItemDto cartItemDto = new CartItemDto();
                cartItemDto.setId(item.getId());
                cartItemDto.setName(item.getProduct().getName());
                cartItemDto.setPrice(item.getProduct().getPrice());
                cartItemDto.setQuantity(item.getQuantity());

                cartItemList.add(cartItemDto);
            }
            cartDto.setItems(cartItemList);

            return cartDto;
        }

        return null;
    }

    public void updateUserCart(CartDto cartDto, Integer userId) {
        for (CartItemDto itemDto : cartDto.getItems()) {
            Product product;
            if (itemDto.getId() != null) {
                product = cartItemRepository.findCartItemById(itemDto.getId()).getProduct();
            } else {
                product = productRepository.findFirstById(itemDto.getProductId());
            }

            Cart cart = cartRepository.findFirstCartByUserId(userId);
            if (cart == null) {
                cart = new Cart();
                cart.setUser(userRepository.findOne(userId));
                cart.setCreatedDate(new Date());
                cart = cartRepository.save(cart);
            }

            if (cartItemRepository.findByCartIdAndProductId(cart.getId(), product.getId()) != null) {
                cartItemRepository.update(itemDto.getQuantity(), cart, product);
            } else {
                CartItem item = new CartItem();
                item.setId(itemDto.getId());
                item.setQuantity(itemDto.getQuantity());
                item.setProduct(product);
                item.setCart(cart);

                cartItemRepository.save(item);
            }
        }
    }

    public void deleteItemFromCartSession(CartDto cart, Integer productId) {
        List<CartItemDto> items = cart.getItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId() == productId) {
                items.remove(i);
                return;
            }
        }
    }

    public void deleteItemFromDBCart(Integer userId, Integer productId) {
        Cart cart = cartRepository.findFirstCartByUserId(userId);
        if (cart != null) {
            CartItem item = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId);
            if (item != null) {
                cartItemRepository.delete(item);
            }
        }
    }
}
