package com.dth.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dth.Entity.Product_Category;
import com.dth.Imp.ProductCategoryImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductCategoryDAO implements ProductCategoryImp {


	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Product_Category> getProductcategory() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Product_Category> ListCategory = (List<Product_Category>) session.createQuery("from product_category").getResultList();
		
		return ListCategory;
	}

}
