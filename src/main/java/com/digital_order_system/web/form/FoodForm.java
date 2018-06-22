package com.digital_order_system.web.form;

public class FoodForm {

	private Integer id;

	private String name;
	
	private String imagePath;
	
	private Float price;
	
	private Float reducePrice;
	
	private Integer categoryId; 
	
	public FoodForm() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getReducePrice() {
		return reducePrice;
	}

	public void setReducePrice(Float reducePrice) {
		this.reducePrice = reducePrice;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
