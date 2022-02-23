package com.springboot.videoservice.app;

public class Video {
	
	public String id;
	public String name;
	
	public int orderNumber;
	

	public Video(String id, String name) {
		this.id = id;
		this.name = name;
		orderNumber = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
