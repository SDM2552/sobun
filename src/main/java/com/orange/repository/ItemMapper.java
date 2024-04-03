package com.orange.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.orange.model.Item;

@Mapper
public interface ItemMapper {
	
	int selectCount();
	
	@Select("select * from item")
	List<Item> selectAll();

	@Select("select * from item where item_id=#{itemId}")
	Item selectByItemId(Long itemId);
	
	void insertItem(Item item);
	
	Item findItemById(@Param("itemId") Long itemId);
	
	@Select("SELECT i.item_Id, i.category, i.name, i.price, i.image, ci.quantity AS cart_item_quantity " +
	        "FROM item i " +
	        "JOIN cart_item ci ON i.item_Id = ci.item_id " +
	        "WHERE ci.cart_id = #{cartId}")
	List<Item> findItemsByCartId(Long cartId);

}
