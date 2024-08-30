package com.tnsif.sm.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> list()
	{
		return service.listAll();
	}
	//retrieve 
	@GetMapping("/products/{id}")
	public ResponseEntity<Product>get(@PathVariable Integer id)
	{
		try
		{
			Product product=service.get(id);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
			}
		catch(Exception e)
		{
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	//create
	@PostMapping("/products")
	public void add(@RequestBody Product product)
	{
		service.save(product);
		
	}
	
	//update
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<?> updateProduct(@PathVariable("id") int id, @RequestBody Product productDetails) {
	        return service.getById(id).map(productItem -> {
	        	
	        	productItem.setName(productDetails.getName());
	        	productItem.setDescription(productDetails.getDescription());
	        	productItem.setPrice(productDetails.getPrice());
	        	productItem.setStockQuantity(productDetails.getStockQuantity());
	        	productItem.setCategory(productDetails.getCategory());
	        	productItem.setStoreId(productDetails.getStoreId());
	        	
	        
               service.save(productItem);
               return new ResponseEntity<>(" updated successfully", HttpStatus.OK);
	            }).orElseGet(() -> {
	            String errorMessage = "Invalid " + id;
	            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	           });
	               
	    }
	
	
	//delete		
@DeleteMapping("/products/{id}")
public void deleteUser(@PathVariable Integer id) {
    service.delete(id);
}}


