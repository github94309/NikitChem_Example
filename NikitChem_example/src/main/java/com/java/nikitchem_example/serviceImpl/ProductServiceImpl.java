package com.java.nikitchem_example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.nikitchem_example.dao.ProductDao;
import com.java.nikitchem_example.model.Product;
import com.java.nikitchem_example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
		@Autowired
		ProductDao productDao;
		 
	    @Override
		public boolean isProduct(int id) {
			// TODO Auto-generated method stub
			 return productDao.isProduct(id);
		}
	    
		@Override
		public boolean isProduct(String name) {
			// TODO Auto-generated method stub
			return productDao.isProduct(name);
		}
		
		@Override
		public Product addProduct(Product product) {
			if(isProduct(product.getName())) {
				return null;
			}
			productDao.addProduct(product);
			return null;
		}
		

		@Override
		public List<Product> getAllProducts() {
			// TODO Auto-generated method stub
			return productDao.getAllProducts();
		}

		@Override
		public Product getProductById(int id) {
			// TODO Auto-generated method stub
			return productDao.getProductById(id);
		}

		@Override
		public Product updateProductInfo(Product product) {
			if(isProduct(product.getId())) {
				productDao.updateProductInfo(product);
				return getProductById(product.getId());
			}
			
			return null;
		}

		@Override
		public int deleteProduct(int id) {
			if(isProduct(id)) {
				productDao.deleteProduct(id);
		    	 return id;
		     }
			return 0;
		}


}
