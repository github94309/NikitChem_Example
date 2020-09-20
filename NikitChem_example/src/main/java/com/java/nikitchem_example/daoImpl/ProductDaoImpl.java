package com.java.nikitchem_example.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.nikitchem_example.dao.ProductDao;
import com.java.nikitchem_example.model.Product;
	

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public Product addProduct(Product product) {
		int id = (int) sessionFactory.getCurrentSession().save(product);
		
		if(isProduct(id)) {
			return product;
		}
		return null; 
	}

	@Override
	public boolean isProduct(int id) {
		return sessionFactory.getCurrentSession().createQuery("From Product where id = :id")
		.setParameter("id", id).getResultList().size()>0;
	}

	@Override
	public boolean isProduct(String name) {
		
		List<Product> products = sessionFactory.getCurrentSession().createQuery("From Product where name=:productName").setParameter("productName", name).getResultList();
		return products.size()>0;
	}

	@Override
	public List<Product> getAllProducts() {
		
		return sessionFactory.getCurrentSession().createQuery("From Product").getResultList();
	}

	@Override
	public Product getProductById(int id) {
		
		List<Product> productList = sessionFactory.getCurrentSession().createQuery("From Product where id=:id")
				.setParameter("id", id).getResultList();
		if (productList.size() > 0) {
			return productList.get(0);
		}
		
		return null;
	}
	@Override
	public int updateProductInfo(Product product) {
		return (int)sessionFactory.getCurrentSession().createQuery("Update Product pro Set pro.name = :name, pro.price= :price where id=:id")
					.setParameter("name", product.getName())
					.setParameter("price", product.getPrice())				
					.setParameter("id", product.getId())
					.executeUpdate();
	}
	@Override
	public int deleteProduct(int id) {
		
		return sessionFactory.getCurrentSession().createQuery("Delete From Product where id=:id").setParameter("id",id).executeUpdate();
	}


}
