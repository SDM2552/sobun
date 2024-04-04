package com.orange.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {

	@PostMapping("/user/{userId}/order")
    public String order(@RequestBody List<Long> selectedItems) {
		
    	return "order";
    }
	
}
