package com.digital_order_system.web.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_order_system.domain.Category;
import com.digital_order_system.domain.Food;
import com.digital_order_system.domain.Order;
import com.digital_order_system.service.CategoryService;
import com.digital_order_system.service.FoodService;
import com.digital_order_system.service.OrderService;
import com.digital_order_system.web.form.CategoryForm;
import com.digital_order_system.web.form.FoodForm;
import com.digital_order_system.web.form.OrderForm;

@RestController
@RequestMapping(value="/rest/dos")
public class DigitalOrderSystemRestController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value="/category/all")
	public List<Category> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping(value="/food/all")
	public List<Food> getAllFoods(){
		return foodService.getAll();
	}
	
	@PostMapping(value="/food/place_order")
	public Order paceOrder(@RequestBody OrderForm orderForm) throws IllegalAccessException, InvocationTargetException{
		return orderService.addOrder(orderForm);
	}
	
	@GetMapping(value="/food/category/{id}")
	public List<Food> getFoodsByCategory(@PathVariable("id") Integer id){
		return foodService.getFoodByCategory(id);
	}
	
	@PostMapping(value="/admin/category/add")
	public Category addCategory(@RequestBody CategoryForm categoryFrom) {
		return categoryService.add(new Category(categoryFrom.getName()));
	}
	
	@PostMapping(value="/admin/food/add")
	public Food addFood(@RequestBody FoodForm foodForm) {
		Food food = new Food(foodForm.getName(), foodForm.getImagePath(), foodForm.getPrice(), foodForm.getReducePrice());
		
		Category category = categoryService.findById(foodForm.getCategoryId());
		
		food.setCategory(category);
		
		return foodService.add(food);
	}
}
