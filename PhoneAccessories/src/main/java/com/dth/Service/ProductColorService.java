package com.dth.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dth.DAO.ProductColorDAO;
import com.dth.Entity.Product_Color;
import com.dth.Imp.ProductColorImp;

@Service
public class ProductColorService implements ProductColorImp {
	@Autowired
	ProductColorDAO productColorDAO;

	public List<Product_Color> getListProductColor() {
		
		return productColorDAO.getListProductColor();
	}

}
