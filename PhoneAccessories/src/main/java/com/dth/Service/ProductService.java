package com.dth.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dth.DAO.ProductDAO;
import com.dth.Entity.Product;
import com.dth.Imp.ProductImp;

@Service
public class ProductService implements ProductImp {
	@Autowired 
	ProductDAO productDAO;

	public List<Product> getProductList(int startProduct) {
		
		return productDAO.getProductList(startProduct);
	}

	public Product getProductDetailById(int product_id) {
		
		return productDAO.getProductDetailById(product_id);
	}

	public List<Product> GetProductByCategoryId(int category_id) {
		return productDAO.GetProductByCategoryId(category_id);
	}

	public boolean DeleteProductById(int productId) {
		return productDAO.DeleteProductById(productId);
	}

	public boolean AddProductAdmin(Product product) {
		
		return productDAO.AddProductAdmin(product);
	}

	public boolean ProductUpdateAdmin(Product product) {
		
		return productDAO.ProductUpdateAdmin(product);
	}

}
