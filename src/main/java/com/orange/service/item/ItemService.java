package com.orange.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.model.Item;
import com.orange.repository.ItemMapper;

@Service
public class ItemService {

	@Autowired
	ItemMapper itemMapper;
	
	public List<Item> printItemList() {
		return itemMapper.selectAll();
	}
	public Item itemdetail(Long itemId) {
		return itemMapper.selectByItemId(itemId);
	}
	public void insertItem(Item item) {
		itemMapper.insertItem(item);
	}

}
