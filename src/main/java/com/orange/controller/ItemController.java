package com.orange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

	@GetMapping("/")
	public String root() {
		return "root";
	}
	@GetMapping("/")
	public String list() {
		return "list";
	}
	
}
