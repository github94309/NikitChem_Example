package com.java.nikitchem_example.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.nikitchem_example.dao.StockDao;
import com.java.nikitchem_example.model.Product;
import com.java.nikitchem_example.model.Stock;
	

@Repository
@Transactional
public class StockDaoImpl implements StockDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Stock addStock(Stock stock) {
		int id = (int) sessionFactory.getCurrentSession().save(stock);
		
		if(isStock(id)) {
			return stock;
		}
		return null; 
	}

	@Override
	public boolean isStock(int id) {
		return sessionFactory.getCurrentSession().createQuery("From Stock where id = :id")
		.setParameter("id", id).getResultList().size()>0;
	}

	@Override
	public boolean isStock(Product product) {
		
		List<Stock> stocks = sessionFactory.getCurrentSession().createQuery("From Stock where product=:stockProduct").setParameter("stockProduct", product).getResultList();
		return stocks.size()>0;
	}

	@Override
	public List<Stock> getAllStocks() {
		
		return sessionFactory.getCurrentSession().createQuery("From Stock").getResultList();
	}

	@Override
	public Stock getStockById(int id) {
		
		List<Stock> StockList = sessionFactory.getCurrentSession().createQuery("From Stock where id=:id")
				.setParameter("id", id).getResultList();
		if (StockList.size() > 0) {
			return StockList.get(0);
		}
		
		return null;
	}
	@Override
	public int updateStockInfo(Stock stock) {
		return sessionFactory.getCurrentSession().createQuery("Update Stock stoc Set stoc.product = :product, stoc.store = :store, stoc.price= :price, stoc.quantity= :quantity where stoc.id=:id")
					.setParameter("product", stock.getProducts().get(0))
					.setParameter("store", stock.getStore())
					.setParameter("quantity", stock.getQuantity())
					.setParameter("id", stock.getId())
					.executeUpdate();
	}
	@Override
	public int deleteStock(int id) {
		
		return sessionFactory.getCurrentSession().createQuery("Delete From Stock where id=:id").setParameter("id",id).executeUpdate();
	}


}


