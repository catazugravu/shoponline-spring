package com.iquest.shoponline.repository;

import com.iquest.shoponline.dto.cartItem.CartItemDto;
import com.iquest.shoponline.model.CartItem;
import com.iquest.shoponline.model.Product;
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
}
