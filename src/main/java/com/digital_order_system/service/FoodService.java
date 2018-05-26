package com.digital_order_system.service;

import java.util.List;

import com.digital_order_system.domain.Food;

public interface FoodService {
	List<Food> getFoodByCategory(Integer id);
	
	List<Food> getAll();
	
	Food add(Food food);
}
