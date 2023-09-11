package com.dth.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dth.Entity.Product;
import com.dth.Entity.ProductCart;
import com.dth.Entity.Product_Category;
import com.dth.Service.ProductCategoryService;
import com.dth.Service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("detailproduct/")
@SessionAttributes("cart")
public class DetailProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	

	
	@GetMapping("{product_id}")
	public String Default(@PathVariable int product_id,ModelMap map,HttpSession httpSession) {
		if(httpSession.getAttribute("email") != null) {
			String mail = (String) httpSession.getAttribute("email");
			String first_character = mail.substring(0, 1);
			map.addAttribute("fc", first_character);
		}
		
		Product product = productService.getProductDetailById(product_id);
		List<Product_Category> categories = productCategoryService.getProductcategory();
	 
		
		if(httpSession.getAttribute("cart") != null) {
			List<ProductCart> productCarts = (List<ProductCart>) httpSession.getAttribute("cart");
			map.addAttribute("NumberOfProduct", productCarts.size());
		}

		map.addAttribute("product", product);
		map.addAttribute("categories", categories);
		
		return "DetailProduct";
	}

}
