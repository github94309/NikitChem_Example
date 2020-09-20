package com.java.nikitchem_example.dao;

import java.util.List;

import com.java.nikitchem_example.model.Product;

public interface ProductDao {
		
		public boolean isProduct(int id);
		public boolean isProduct(String name);
		public Product addProduct(Product product);
		public List<Product> getAllProducts();
		public Product getProductById(int id);
		public int updateProductInfo(Product product);
		public int deleteProduct(int id);

	}

