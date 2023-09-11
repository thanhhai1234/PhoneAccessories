package com.dth.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dth.Entity.JSON_Product;
import com.dth.Entity.Product;
import com.dth.Entity.ProductCart;
import com.dth.Entity.Product_Category;
import com.dth.Entity.Product_Color;
import com.dth.Entity.Product_Details;
import com.dth.Service.EmployeeService;
import com.dth.Service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("api/")
@SessionAttributes({"email", "cart"})
public class APIController {

    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    ProductService productService;

    @GetMapping("checklogin")
    @ResponseBody
    public String CheckLogin(@RequestParam String employee_email, String employee_password, ModelMap map) {
        boolean check = employeeService.CheckLogin(employee_email, employee_password);
        map.addAttribute("email", employee_email);
        return "" + check;

    }
    
    @GetMapping("updatecartproduct")
    @ResponseBody
    public void UpdateCartProduct(HttpSession httpSession,@RequestParam int product_id, @RequestParam int color_id,@RequestParam int quantity) {
    	if (httpSession.getAttribute("cart") != null) {
    		List<ProductCart> listCart = (List<ProductCart>) httpSession.getAttribute("cart");
    		int location = CheckProductAlreadyExists(product_id, color_id, httpSession);
             listCart.get(location).setQuantity(quantity);
    	}
    	
    }
    
    @GetMapping("deleteproduct")
    @ResponseBody
    public void DeleteProduct(HttpSession httpSession,@RequestParam int product_id, @RequestParam int color_id) {
    	if (httpSession.getAttribute("cart") != null) {
    		List<ProductCart> listCart = (List<ProductCart>) httpSession.getAttribute("cart");
    		int location = CheckProductAlreadyExists(product_id, color_id, httpSession);
             listCart.remove(location);
    	}
    	
    }

    
    @GetMapping("addtocart")
    @ResponseBody
    public String AddToCart(@RequestParam int Product_details_id, @RequestParam int product_id, @RequestParam int color_id, @RequestParam int quantity, @RequestParam String product_name, @RequestParam String price, @RequestParam String color_name,@RequestParam String path_image, HttpSession httpSession) {

        if (httpSession.getAttribute("cart") == null) {
            List<ProductCart> productCarts = new ArrayList<ProductCart>();
            ProductCart carts = new ProductCart();
            carts.setProductDetails_id(Product_details_id);
            carts.setProduct_id(product_id);
            carts.setColor_id(color_id);
            carts.setQuantity(1);
            carts.setProduct_name(product_name);
            carts.setPrice(price);
            carts.setColor_name(color_name);
            carts.setPath_image(path_image);
            productCarts.add(carts);
            httpSession.setAttribute("cart", productCarts);
            List<ProductCart> listCart = (List<ProductCart>) httpSession.getAttribute("cart");
            return "" + listCart.size();
            
        } else {
            List<ProductCart> listCart = (List<ProductCart>) httpSession.getAttribute("cart");
            int location = CheckProductAlreadyExists(product_id, color_id, httpSession);
            if (location == -1) {
                ProductCart carts = new ProductCart();
                carts.setProductDetails_id(Product_details_id);
                carts.setProduct_id(product_id);
                carts.setColor_id(color_id);
                carts.setQuantity(1);
                carts.setProduct_name(product_name);
                carts.setPrice(price);
                carts.setColor_name(color_name);
                carts.setPath_image(path_image);
                listCart.add(carts);
            } else {
                int newQuantity = listCart.get(location).getQuantity() + 1;
                listCart.get(location).setQuantity(newQuantity);
            }
            return "" + listCart.size();
        }
    }

    private int CheckProductAlreadyExists(int product_id, int color_id, HttpSession httpSession) {
        List<ProductCart> listCart = (List<ProductCart>) httpSession.getAttribute("cart");
        for (int i = 0; i < listCart.size(); i++) {
            if (listCart.get(i).getProduct_id() == product_id && listCart.get(i).getColor_id() == color_id) {
                System.out.println("tra ve i:" + i);
                return i;
            }
        }
        return -1;
    }
    
    
    @GetMapping("GetProductNumberOfPage")
    @ResponseBody
    public String GetProductNumberOfPage(@RequestParam int productnumber) {
    	
    	String html = "";
    	List<Product> listProducts =productService.getProductList(productnumber);
    	for (Product product : listProducts) {
			html += "<tr>";
			html += "<td><div class='checkbox'><label><input class='checkboxProduct' type='checkbox' value='"+product.getProduct_id()+"'/></label></div></td>";
			html += "<td style='color:black;' class='' data-Id ='"+product.getProduct_id()+"'>"+product.getProduct_name()+"</td>";
			html += "<td style='color:black;' class=''>"+product.getProduct_price()+"</td>";
			html += "<td class='productUpdate' data-id='"+product.getProduct_id()+"'>Update</td>";
			html += "</tr>";
		}
    	

        return html;

    }
    
    @GetMapping("deleteProduct")
    @ResponseBody
    public String DeleteProductById(@RequestParam int productId) {
    	productService.DeleteProductById(productId);
    	return"";
    }
    
    
    
    @Autowired
    ServletContext servletContext;
    
    @PostMapping("uploadfile")
    @ResponseBody
    public String UpLoadFile(MultipartHttpServletRequest request) {
    	String PathToProducts = servletContext.getRealPath("/resources/Image/products/");
    	Iterator<String> imageName = request.getFileNames();
    	MultipartFile imageFile =request.getFile(imageName.next());
    	System.out.print("name "+imageFile);
    	File fileSave = new File(PathToProducts + imageFile.getOriginalFilename());
    	try {
			imageFile.transferTo(fileSave);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(PathToProducts);
    	
    	return"";
    }
    
    @PostMapping("AddProductFromAdmin")
    @ResponseBody
    public void AddProductFromAdmin(@RequestParam String dataJson) {
    	ObjectMapper objectMapper = new ObjectMapper();
    	
    	
    	JsonNode jsonObject;
    	try {
    		Product product = new Product();
    		jsonObject = objectMapper.readTree(dataJson);
    		
    		Product_Category product_Category = new Product_Category();
    		product_Category.setCategory_id(jsonObject.get("product_Category").asInt());
    		
			JsonNode jsonDetails = jsonObject.get("product_Details");
			Set<Product_Details> listDetails = new HashSet<Product_Details>();
			for (JsonNode objectDetails : jsonDetails) {
				Product_Details product_Details = new Product_Details();
				
				Product_Color product_Color = new Product_Color();
				product_Color.setColor_id(objectDetails.get("productColor").asInt());

				product_Details.setProduct_Color(product_Color);
				product_Details.setQuantity(objectDetails.get("numberOfProduct").asInt());
				
				listDetails.add(product_Details);
				
			}
			
			String product_name = jsonObject.get("product_name").asText();
			String product_price = jsonObject.get("product_price").asText();
			String description_product = jsonObject.get("description_product").asText();
			String product_image = jsonObject.get("product_image").asText();
			
			product.setProduct_Details(listDetails);
			product.setProduct_Category(product_Category);
			product.setProduct_name(product_name);
			product.setProduct_price(product_price);
			product.setDescription_product(description_product);
			product.setProduct_image(product_image);
			
			productService.AddProductAdmin(product);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @PostMapping("ProductUpdateAdmin")
    @ResponseBody
    public void ProductUpdateAdmin(@RequestParam String dataJson) {
    	ObjectMapper objectMapper = new ObjectMapper();
    	
    	JsonNode jsonObject;
    	try {
    		Product product = new Product();
    		jsonObject = objectMapper.readTree(dataJson);
    		
    		Product_Category product_Category = new Product_Category();
    		product_Category.setCategory_id(jsonObject.get("product_Category").asInt());
    		
			JsonNode jsonDetails = jsonObject.get("product_Details");
			Set<Product_Details> listDetails = new HashSet<Product_Details>();
			for (JsonNode objectDetails : jsonDetails) {
				Product_Details product_Details = new Product_Details();
				
				Product_Color product_Color = new Product_Color();
				product_Color.setColor_id(objectDetails.get("productColor").asInt());

				product_Details.setProduct_Color(product_Color);
				product_Details.setQuantity(objectDetails.get("numberOfProduct").asInt());
				
				listDetails.add(product_Details);
				
			}
			
			String product_name = jsonObject.get("product_name").asText();
			String product_price = jsonObject.get("product_price").asText();
			String description_product = jsonObject.get("description_product").asText();
			String product_image = jsonObject.get("product_image").asText();
			int product_id = jsonObject.get("productId").asInt();
			
			product.setProduct_Details(listDetails);
			product.setProduct_Category(product_Category);
			product.setProduct_name(product_name);
			product.setProduct_price(product_price);
			product.setDescription_product(description_product);
			product.setProduct_image(product_image);
			product.setProduct_id(product_id);
			
			productService.ProductUpdateAdmin(product);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @PostMapping("GetProductListByIdAdmin")
    @ResponseBody
    public JSON_Product GetProductListByIdAdmin(@RequestParam int product_id ){
    	JSON_Product json_Product = new JSON_Product();
    	Product product = productService.getProductDetailById(product_id);
    	
    	json_Product.setProduct_id(product.getProduct_id());
    	json_Product.setProduct_name(product.getProduct_name());
    	json_Product.setProduct_price(product.getProduct_price());
    	json_Product.setDescription_product(product.getDescription_product());
    	json_Product.setProduct_image(product.getProduct_image());
    	
    	Product_Category product_Category = new Product_Category();
    	product_Category.setCategory_id(product.getProduct_Category().getCategory_id());
    	product_Category.setCategory_name(product.getProduct_Category().getCategory_name());
    	
    	Set<Product_Details> product_Details = new HashSet<Product_Details>();
    	for (Product_Details value : product.getProduct_Details()) {
    		Product_Details product_Details2 = new Product_Details();
    		product_Details2.setProduct_details_id(value.getProduct_details_id());
    		
    		Product_Color product_Color = new Product_Color();
    		product_Color.setColor_id(value.getProduct_Color().getColor_id());
    		product_Color.setColor_name(value.getProduct_Color().getColor_name());
    		
    		product_Details2.setProduct_Color(product_Color);
    		product_Details2.setQuantity(value.getQuantity());
    		
    		product_Details.add(product_Details2);
    		
			
		}
    	
    	json_Product.setProduct_Category(product_Category);
    	json_Product.setProduct_Details(product_Details);
    	
    	return json_Product;
    }
    
    


}
