package com.java.nikitchem_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.nikitchem_example.model.Product;
import com.java.nikitchem_example.service.ProductService;
import com.java.nikitchem_example.serviceImpl.ProductServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		
		try {
			return new ResponseEntity<Object> (productService.addProduct(product),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllProducts() {
		
		try {
			return new ResponseEntity<Object>(productService.getAllProducts(), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getProductById(@PathVariable int id){
		try {
			return new ResponseEntity<Object>(productService.getProductById(id),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProductById( @PathVariable int id, @RequestBody Product product){
		try {
			return new ResponseEntity<Object>(productService.updateProductInfo(product),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable int id){
		try {
			return new ResponseEntity<Object>(productService.deleteProduct(id),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}

