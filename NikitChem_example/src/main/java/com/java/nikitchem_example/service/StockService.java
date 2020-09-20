package com.java.nikitchem_example.service;

import java.util.List;

import com.java.nikitchem_example.model.Product;
import com.java.nikitchem_example.model.Stock;

public interface StockService {
	
	public boolean isStock(int id);
	
	public boolean isStock(Product product);
	
	public Stock addStock(Stock stock);
	
	public List<Stock> getAllStocks();
	
	public Stock getStockById(int id);
	
	public Stock updateStockInfo(Stock stock);
	
	public int deleteStock(int id);

}