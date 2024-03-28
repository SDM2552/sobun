package com.orange.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String category;
	private String name;
	private double Price;
	private int quantity;
	private String description;
	private String image;
	private String regdate;
	
}
