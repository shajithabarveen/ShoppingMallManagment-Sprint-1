package com.tnsif.sm.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product 
{
	
	private Integer id;
	private String name;
	private String description;
	private float price;
	private Long stockQuantity;
	private String category;
	private Long storeId;
	
	public Product()
	{
	
	}
	public Product(Integer id, String name,String description, float price,Long stockQuantity,
	String category, Long  storeId		) {
	
		
		this.id = id;
		this.name = name;
		this.description=description;
		this.price = price;
		this.stockQuantity=stockQuantity;
		this.category=category;
		this.storeId=storeId;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
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
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Long getStockQuantity()
	{
		return stockQuantity;
	}
	public void setStockQuantity(Long stockQuantity )
	{
		this.stockQuantity=stockQuantity;
	}
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category=category;
	}
	public Long getStoreId()
	{
		return storeId;
	}
	public void setStoreId(Long storeId )
	{
		this.storeId=storeId;
	}
	
	
	

}
