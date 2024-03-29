package com.orange.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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
}
