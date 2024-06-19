package com.pragma.models;

public class Item {
	
	private String name;
	private Integer price;
	private String description;
	
	public Item(String name, Integer price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", description=" + description + "]";
	}
		
}
