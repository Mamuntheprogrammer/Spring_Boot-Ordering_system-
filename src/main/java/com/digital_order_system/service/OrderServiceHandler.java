package com.digital_order_system.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_order_system.domain.Order;
import com.digital_order_system.domain.OrderItem;
import com.digital_order_system.repo.OrderItemRepository;
import com.digital_order_system.repo.OrderRepository;
import com.digital_order_system.web.form.OrderForm;
import com.digital_order_system.web.form.OrderItemForm;

@Service
public class OrderServiceHandler implements OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public Order addOrder(OrderForm orderForm) throws IllegalAccessException, InvocationTargetException {
		
		Order order = new Order();
		
		order.setId(orderForm.getId());
		order.setTableNo(orderForm.getTableNo());
		order.setOrderTotal(orderForm.getOrderTotal());
		order.setUserId(orderForm.getUserId());
		order.setComment(orderForm.getComment());
		
		order = orderRepo.saveAndFlush(order);
		
		for(OrderItemForm orderItemForm : orderForm.getOrderItems()){
			OrderItem orderItem = new OrderItem();
			orderItem.setId(orderItemForm.getId());
			orderItem.setName(orderItemForm.getName());
			orderItem.setPrice(orderItemForm.getPrice());
			orderItem.setQuantity(orderItemForm.getQuantity());
			orderItem.setOrder(order);
			orderItemRepo.saveAndFlush(orderItem);
		}
		
		return order;
	}

}
