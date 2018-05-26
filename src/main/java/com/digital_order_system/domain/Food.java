package com.digital_order_system.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "food")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String name;
	
	@Column(name="image_path")
	private String imagePath;
	
	private Float price;
	
	@Column(name="reduce_price")
	private Float reducePrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category; 

	public Food() {
		
	}
	
	public Food(String name, String imagePath, Float price, Float reducePrice) {
		this.name = name;
		this.imagePath = imagePath;
		this.price = price;
		this.reducePrice = reducePrice;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
