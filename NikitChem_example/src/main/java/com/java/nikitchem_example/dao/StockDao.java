package com.java.nikitchem_example.dao;

import java.util.List;

import com.java.nikitchem_example.model.Product;
import com.java.nikitchem_example.model.Stock;

public interface StockDao {
		
		public boolean isStock(Product product);
		public boolean isStock(int id);
		public Stock addStock(Stock stock);
		public List<Stock> getAllStocks();
		public Stock getStockById(int id);
		public int updateStockInfo(Stock stock);
		public int deleteStock(int id);

	}



