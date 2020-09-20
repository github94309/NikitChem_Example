package com.java.nikitchem_example.service;

import java.util.List;

import com.java.nikitchem_example.model.Product;

public interface ProductService {
		
		public boolean isProduct(int id);
		
		public boolean isProduct(String name);
		
		public Product addProduct(Product product);
		
		public List<Product> getAllProducts();
		
		public Product getProductById(int id);
		
		public Product updateProductInfo(Product product);
		
		public int deleteProduct(int id);

	}

