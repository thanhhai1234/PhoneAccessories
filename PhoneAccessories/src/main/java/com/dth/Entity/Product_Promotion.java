package com.dth.Entity;

import java.util.Set;
import java.util.jar.Attributes.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "Product_Promotion")
public class Product_Promotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int promotion_id;
    String promotion_name;
    String start_time;
    String end_time;
    String description_product;
    String promotion_image;
    int product_sale;
    
    /**
     * one promotion for many products
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Promotion_Details",
    joinColumns = {@JoinColumn(name ="promotion_id",referencedColumnName = "promotion_id")},
    inverseJoinColumns = {@JoinColumn(name="product_id",referencedColumnName = "product_id")})
    Set<Product> List_OF_Product;

    
	public int getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(int promotion_id) {
		this.promotion_id = promotion_id;
	}

	public String getPromotion_name() {
		return promotion_name;
	}

	public void setPromotion_name(String promotion_name) {
		this.promotion_name = promotion_name;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getDescription_product() {
		return description_product;
	}

	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}

	public String getPromotion_image() {
		return promotion_image;
	}

	public void setPromotion_image(String promotion_image) {
		this.promotion_image = promotion_image;
	}

	public int getProduct_sale() {
		return product_sale;
	}

	public void setProduct_sale(int product_sale) {
		this.product_sale = product_sale;
	}

	public Set<Product> getList_OF_Product() {
		return List_OF_Product;
	}

	public void setList_OF_Product(Set<Product> list_OF_Product) {
		List_OF_Product = list_OF_Product;
	}
    
    

}
