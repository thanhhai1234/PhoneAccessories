package com.dth.Entity;

import java.util.Set;

public class JSON_Product {
	int product_id;
	Product_Category product_Category;
	String product_name;
	String product_price;
	String description_product;
	String product_image;
	Set<Product_Details> product_Details;
	Set<Product_Promotion> List_Of_Promotion;
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Product_Category getProduct_Category() {
		return product_Category;
	}
	public void setProduct_Category(Product_Category product_Category) {
		this.product_Category = product_Category;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getDescription_product() {
		return description_product;
	}
	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public Set<Product_Details> getProduct_Details() {
		return product_Details;
	}
	public void setProduct_Details(Set<Product_Details> product_Details) {
		this.product_Details = product_Details;
	}
	public Set<Product_Promotion> getList_Of_Promotion() {
		return List_Of_Promotion;
	}
	public void setList_Of_Promotion(Set<Product_Promotion> list_Of_Promotion) {
		List_Of_Promotion = list_Of_Promotion;
	}
	
	

}
