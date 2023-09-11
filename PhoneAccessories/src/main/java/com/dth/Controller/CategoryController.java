package com.dth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dth.Entity.Product;
import com.dth.Entity.Product_Category;
import com.dth.Service.ProductCategoryService;
import com.dth.Service.ProductService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	ProductCategoryService productCategoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{id}/{category_name}")
	public String Default(ModelMap map,@PathVariable int id,@PathVariable String category_name) {
		List<Product_Category> categories = productCategoryService.getProductcategory();
		map.addAttribute("categories", categories);
		
		List<Product> ListProducts = productService.GetProductByCategoryId(id);
		map.addAttribute("category_name", category_name);
		map.addAttribute("ListProducts", ListProducts);
		
		return "Category";
		
	}

}
