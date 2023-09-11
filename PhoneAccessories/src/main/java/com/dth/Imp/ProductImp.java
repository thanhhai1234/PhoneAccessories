package com.dth.Imp;

import java.util.List;

import com.dth.Entity.Product;

public interface ProductImp {
	List<Product> getProductList(int startProduct);
	Product getProductDetailById(int product_id);
	List<Product> GetProductByCategoryId(int category_id);
	boolean DeleteProductById(int productId);
	boolean AddProductAdmin(Product product);
	boolean ProductUpdateAdmin(Product product);

}
