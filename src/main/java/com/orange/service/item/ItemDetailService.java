package com.orange.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.model.Item;
import com.orange.repository.ItemMapper;

@Service
public class ItemDetailService {
	
	@Autowired
	private ItemMapper itemMapper;
	
	public Item itemdetail(Long itemId) {
		return itemMapper.selectByItemId(itemId);
	}

}
