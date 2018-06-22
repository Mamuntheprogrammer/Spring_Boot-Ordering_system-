package com.digital_order_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_order_system.domain.Category;
import com.digital_order_system.domain.Food;
import com.digital_order_system.repo.CategoryRepository;
import com.digital_order_system.repo.FoodRepository;

@Service
public class FoodServiceHandler implements FoodService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public List<Food> getFoodByCategory(Integer id) {
		
		Category category = categoryRepository.findById(id).get();
		
		List<Food> foods = foodRepository.findByCategory(category);
		
		return foods;
	}

	@Override
	public List<Food> getAll() {
	
		return foodRepository.findAll();
	}

	@Override
	public Food add(Food food) {
		return foodRepository.saveAndFlush(food);
	}

	
}
