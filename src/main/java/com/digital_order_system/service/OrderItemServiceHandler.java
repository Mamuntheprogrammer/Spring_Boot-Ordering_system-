package com.digital_order_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_order_system.domain.OrderItem;
import com.digital_order_system.repo.OrderItemRepository;

@Service
public class OrderItemServiceHandler implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Override
	public OrderItem addOrderItem(OrderItem orderItems) {
		return orderItemRepo.saveAndFlush(orderItems);
	}

}
