package com.dth.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dth.Entity.Invoice;
import com.dth.Entity.Invoice_Details;
import com.dth.Entity.Invoice_Details_Id;
import com.dth.Entity.Product;
import com.dth.Entity.Product_Details;
import com.dth.Imp.ProductImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductDAO implements ProductImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Product> getProductList(int startProduct) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> listProducts = new ArrayList<Product>();
		if(startProduct <0) {
			 listProducts =  session.createQuery("from Product").getResultList();
			
		}else {
			listProducts = session.createQuery("from Product").setFirstResult(startProduct).setMaxResults(10).getResultList();
		}
		
		return listProducts;
	}

	@Transactional
	public Product getProductDetailById(int product_id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.createQuery("from Product where product_id ="+product_id).getSingleResult();
		
		
		return product;
	}
	@Transactional
	public List<Product> GetProductByCategoryId(int category_id) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> listProducts =  session.createQuery("from Product sp where sp.product_Category.category_id ="+category_id).getResultList();
		return listProducts;
	}
	
	@Transactional
	public boolean DeleteProductById(int productId) {
//		Session session = sessionFactory.getCurrentSession();
//		Product product = session.get(Product.class, productId);
//		
//		Set<Product_Details> product_Details =  product.getProduct_Details();
//		for (Product_Details product_Details2 : product_Details) {
//			session.createQuery("delete Invoice_Details where Product_details_id ="+product_Details2.getProduct_details_id()).executeUpdate();
//	
//		}
//		session.createQuery("delete Product_Details where product_id ="+productId).executeUpdate();
//		session.createQuery("delete Product where product_id ="+productId).executeUpdate();
		
		return false;
	}
	
	@Transactional
	public boolean AddProductAdmin(Product product) {
		Session session = sessionFactory.getCurrentSession();
		int productId = (Integer) session.save(product);
		return false;
	}
	

	@Transactional
	public boolean ProductUpdateAdmin(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		return false;
	}

	
	
}
