package com.orange.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.orange.model.CartItem;

@Mapper
public interface CartMapper {

	@Select("insert into cart_item (item_id, quantity) values(#{itemId), #{quantity});")
	CartItem addToCart();
}
