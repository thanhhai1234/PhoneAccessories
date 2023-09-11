package com.dth.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dth.DAO.ProductCategoryDAO;
import com.dth.Entity.Product_Category;
import com.dth.Imp.ProductCategoryImp;

@Service
public class ProductCategoryService implements ProductCategoryImp {
	
	@Autowired
	ProductCategoryDAO productCategoryDAO;

	public List<Product_Category> getProductcategory() {
		
		return productCategoryDAO.getProductcategory();
	}

}
