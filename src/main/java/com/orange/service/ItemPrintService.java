package com.orange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.repository.ItemMapper;

@Service
public class ItemPrintService {

	@Autowired
	ItemMapper itemMapper;
	
	
}
