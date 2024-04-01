package com.orange.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.orange.model.CartItem;

@Mapper
public interface CartItemMapper {

	@Select("select * from cart_item where item_id=#{itemId}")
	CartItem selectByItemId(Long itemId);
}
