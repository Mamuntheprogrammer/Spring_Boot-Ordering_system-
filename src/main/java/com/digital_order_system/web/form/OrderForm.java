package com.digital_order_system.web.form;

import java.util.ArrayList;
import java.util.List;

public class OrderForm {
	
	private Integer id;

	private String tableNo;
	
	private Integer userId;
	
	private Float orderTotal;
	
	private String comment;
	
	private List<OrderItemForm> orderItems = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Float orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<OrderItemForm> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemForm> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
