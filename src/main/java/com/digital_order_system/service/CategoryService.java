package com.digital_order_system.service;

import java.util.List;

import com.digital_order_system.domain.Category;

public interface CategoryService {
	List<Category> getAll();
	
	Category add(Category category);
	
	Category findById(Integer id);
}
