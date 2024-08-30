package com.tnsif.sm.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService 
{
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll()
	{
		return repo.findAll();
	}

	public Product get(Integer id)
	{
		return repo.findById(id).get();
	}

	public void save( Product product) {
		 repo.save(product);
	}

	 public void delete(Integer id) {
	        if (repo.existsById(id)) {
	            repo.deleteById(id);
	        } else {
	            
	            throw new RuntimeException("User not found with id " + id);
	        }
	    }

	 public Optional<Product> getById(int id) {

			return repo.findById(id);
		}
		
		
	

	

	
	}

