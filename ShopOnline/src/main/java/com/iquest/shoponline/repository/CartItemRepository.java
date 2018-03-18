package com.iquest.shoponline.repository;

import com.iquest.shoponline.dto.cartItem.CartItemDto;
import com.iquest.shoponline.model.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

    List<CartItem> findAllByCart_Id(Integer cartId);

    CartItem findByCartIdAndProductId(Integer cartId, Integer productId);

    CartItem findByIdAndCartId(Integer id, Integer cartId);

    @Transactional
    Integer deleteByIdAndCartId(Integer id, Integer cartId);
}
