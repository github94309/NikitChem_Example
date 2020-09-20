package com.java.nikitchem_example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.nikitchem_example.dao.StockDao;
import com.java.nikitchem_example.model.Product;
import com.java.nikitchem_example.model.Stock;
import com.java.nikitchem_example.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	
		 @Autowired
		 StockDao stockDao;
		 
		@Override
		public boolean isStock(int id) {
			// TODO Auto-generated method stub
			 return stockDao.isStock(id);
		}
	    
		@Override
		public boolean isStock(Product product) {
			// TODO Auto-generated method stub
			return stockDao.isStock(product);
		}
		
		@Override
		public Stock addStock(Stock stock) {
			if(isStock(stock.getProducts().get(0))) {
				return updateStockInfo(stock);
			}
			return stockDao.addStock(stock);
			
		}
		

		@Override
		public List<Stock> getAllStocks() {
			// TODO Auto-generated method stub
			return stockDao.getAllStocks();
		}

		@Override
		public Stock getStockById(int id) {
			// TODO Auto-generated method stub
			return stockDao.getStockById(id);
		}

		@Override
		public Stock updateStockInfo(Stock stock) {
			if(isStock(stock.getId())) {
				stockDao.updateStockInfo(stock);
				return getStockById(stock.getId());
			}
			
			return null;
		}

		@Override
		public int deleteStock(int id) {
			if(isStock(id)) {
				stockDao.deleteStock(id);
		    	 return id;
		     }
			return 0;
		}



}
