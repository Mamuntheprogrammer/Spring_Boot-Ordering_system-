package com.digital_order_system.service;

import java.lang.reflect.InvocationTargetException;

import com.digital_order_system.domain.Order;
import com.digital_order_system.web.form.OrderForm;

public interface OrderService {
	Order addOrder(OrderForm orderForm) throws IllegalAccessException, InvocationTargetException;
}
