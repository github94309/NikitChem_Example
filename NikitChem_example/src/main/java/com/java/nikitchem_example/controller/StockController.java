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

import com.java.nikitchem_example.model.Stock;
import com.java.nikitchem_example.service.StockService;

@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class StockController {
	
	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/stocks", method = RequestMethod.POST)
	public ResponseEntity<Object> addStock(@RequestBody Stock stock) {
		
		try {
			return new ResponseEntity<Object> (stockService.addStock(stock),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/stocks", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllStocks() {
		
		try {
			return new ResponseEntity<Object>(stockService.getAllStocks(), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@RequestMapping(value = "/stocks/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getStockById(@PathVariable int id){
		try {
			return new ResponseEntity<Object>(stockService.getStockById(id),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/stocks/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStockById(@PathVariable int id, @RequestBody Stock stock){
		try {
			return new ResponseEntity<Object>(stockService.updateStockInfo(stock),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/stocks/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStock(@PathVariable int id){
		try {
			return new ResponseEntity<Object>(stockService.deleteStock(id),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}

