<<<<<<< HEAD
package com.digital_order_system.web.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.digital_order_system.domain.User;
import com.digital_order_system.service.CategoryService;
import com.digital_order_system.service.FoodService;
import com.digital_order_system.service.OrderService;
import com.digital_order_system.service.UserService;
import com.digital_order_system.web.form.CategoryForm;
import com.digital_order_system.web.form.FoodForm;
import com.digital_order_system.web.form.LoginForm;
import com.digital_order_system.web.form.OrderForm;
import com.digital_order_system.web.form.UserForm;

@RestController
@RequestMapping(value="/rest/dos")
public class DigitalOrderSystemRestController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/category/all")
	public List<Category> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping(value="/food/all")
	public List<Food> getAllFoods(){
		return foodService.getAll();
	}
	
	@PostMapping(value="/food/place_order")
	public Order paceOrder(@RequestBody OrderForm orderForm, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException{
		
		User user = (User)request.getSession().getAttribute("user");
		
		if(user != null){
			orderForm.setUserId(user.getId());
		}
		
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
	
	@PostMapping(value="/user/add")
	public User addUser(@RequestBody UserForm userForm) {
		
		return userService.addUser(userForm);
	}
	
	@PostMapping(value="/user/login")
	public User login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
		
		User user = userService.login(loginForm.getName1(), loginForm.getPassword());
		
		if(user != null){
			request.getSession().setAttribute("user",user);
		}
		
		User user1 = (User)request.getSession().getAttribute("user");
		
		return user;
	}
}
=======
package com.digital_order_system.web.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.digital_order_system.domain.User;
import com.digital_order_system.service.CategoryService;
import com.digital_order_system.service.FoodService;
import com.digital_order_system.service.OrderService;
import com.digital_order_system.service.UserService;
import com.digital_order_system.web.form.CategoryForm;
import com.digital_order_system.web.form.FoodForm;
import com.digital_order_system.web.form.LoginForm;
import com.digital_order_system.web.form.OrderForm;
import com.digital_order_system.web.form.UserForm;

@RestController
@RequestMapping(value="/rest/dos")
public class DigitalOrderSystemRestController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/category/all")
	public List<Category> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping(value="/food/all")
	public List<Food> getAllFoods(){
		return foodService.getAll();
	}
	
	@PostMapping(value="/food/place_order")
	public Order paceOrder(@RequestBody OrderForm orderForm, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException{
		
		User user = (User)request.getSession().getAttribute("user");
		
		if(user != null){
			orderForm.setUserId(user.getId());
		}
		
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
	
	@PostMapping(value="/user/add")
	public User addUser(@RequestBody UserForm userForm) {
		
		return userService.addUser(userForm);
	}
	
	@PostMapping(value="/user/login")
	public User login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
		
		User user = userService.login(loginForm.getName1(), loginForm.getPassword());
		
		if(user != null){
			request.getSession().setAttribute("user",user);
		}
		
		User user1 = (User)request.getSession().getAttribute("user");
		
		return user;
	}
}
>>>>>>> branch 'master' of https://github.com/Mamuntheprogrammer/final-_project.git
