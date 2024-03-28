package com.orange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orange.model.Item;
import com.orange.service.item.ItemDetailService;
import com.orange.service.item.ItemPrintService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemPrintService itemPrintService;
	@Autowired
	private ItemDetailService itemDetailService;

	@GetMapping("/")
	public String root() {
		return "root";
	}
	@GetMapping("/main")
	public String root2() {
		return "root";
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<Item> list = itemPrintService.printItemList(); 
		model.addAttribute("list", list);
		return "list";
	}
	@GetMapping("/item")
	public String item(@RequestParam("itemId") Long itemId, Model model) {
		Item item = itemDetailService.itemdetail(itemId);
		model.addAttribute("item", item);
		return "item";
	}
	
}
