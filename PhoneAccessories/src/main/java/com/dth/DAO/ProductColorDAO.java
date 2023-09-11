package com.dth.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dth.Entity.Product_Color;
import com.dth.Imp.ProductColorImp;

import jakarta.transaction.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductColorDAO implements ProductColorImp {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<Product_Color> getListProductColor() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Product_Color> ListColor =  session.createQuery("from Product_Color").getResultList();
		return ListColor;
	}

}
