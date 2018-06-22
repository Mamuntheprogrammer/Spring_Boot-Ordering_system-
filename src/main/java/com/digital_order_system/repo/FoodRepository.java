package com.digital_order_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_order_system.domain.Category;
import com.digital_order_system.domain.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
	List<Food> findByCategory(Category category);
}
