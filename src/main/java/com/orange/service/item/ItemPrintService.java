package com.orange.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.model.Item;
import com.orange.repository.ItemMapper;

@Service
public class ItemPrintService {

	@Autowired
	ItemMapper itemMapper;
	
	public List<Item> printItemList() {
		return itemMapper.selectAll();
	}
}
