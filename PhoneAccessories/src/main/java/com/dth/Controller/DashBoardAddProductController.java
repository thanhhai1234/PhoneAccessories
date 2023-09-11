package com.dth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dth.Entity.Product;
import com.dth.Entity.Product_Category;
import com.dth.Entity.Product_Color;
import com.dth.Service.ProductCategoryService;
import com.dth.Service.ProductColorService;
import com.dth.Service.ProductService;

@Controller
@RequestMapping("/dashboardaddproduct/")
public class DashBoardAddProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@Autowired
	ProductColorService productColorService;
	
	@GetMapping
	public String Default(ModelMap map) {
		
		List<Product> ListProducts = productService.getProductList(0);
		List<Product> AllProducts = productService.getProductList(-1);
		double AllPage = Math.ceil((double) AllProducts.size()/5);
		map.addAttribute("ListProducts", ListProducts);
		map.addAttribute("AllProducts", AllProducts);
		map.addAttribute("AllPage", AllPage);
		
		List<Product_Category> categories = productCategoryService.getProductcategory();
		map.addAttribute("categories", categories);
		
		List<Product_Color> listColor = productColorService.getListProductColor();
		map.addAttribute("listColor", listColor);
		return "DashBoardAddProduct";
	}

}
