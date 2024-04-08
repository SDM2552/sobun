package com.orange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private double Price;
	@Column(nullable = false)
	private int quantity;
	private int sales;
	private String description;
	private String image;
	private String imagePath;
	private String regdate;
	
}
