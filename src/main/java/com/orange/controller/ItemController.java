package com.orange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orange.aop.LoginCheck;
import com.orange.model.Item;
import com.orange.service.item.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;


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
		List<Item> list = itemService.printItemList(); 
		model.addAttribute("list", list);
		return "list";
	}
	@GetMapping("/item")
	public String item(@RequestParam("itemId") Long itemId, Model model) {
		Item item = itemService.itemdetail(itemId);
		model.addAttribute("item", item);
		return "item";
	}
	@LoginCheck
	@GetMapping("/buyPage")
	public String buyForm() {
		return "buyPage";
	}
	@GetMapping("/addItems")
	public String addItems() {
		return "addItems";
	}
	@PostMapping("/add")
	public String addItems2(Item item) {
		itemService.insertItem(item);
		return "redirect:/addItems";
	}
	@LoginCheck
	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}
	
}
