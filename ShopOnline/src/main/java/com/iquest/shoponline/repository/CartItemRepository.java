package com.iquest.shoponline.repository;

import com.iquest.shoponline.dto.cartItem.CartItemDto;
import com.iquest.shoponline.model.Cart;
import com.iquest.shoponline.model.CartItem;
import com.iquest.shoponline.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

    List<CartItem> findAllByCart_UserId(Integer userId);

    CartItem findByCartIdAndProductId(Integer cartId, Integer productId);

    CartItem findByIdAndCartId(Integer id, Integer cartId);

    CartItem findCartItemById(Integer id);

    @Transactional
    Integer deleteByIdAndCartId(Integer id, Integer cartId);

    @Modifying
    @Transactional
    @Query("update CartItem c_i set c_i.quantity = :quantity where c_i.cart = :cart and c_i.product = :product")
    Integer update(@Param("quantity") Integer quantity, @Param("cart") Cart cartId, @Param("product") Product productId);
}
