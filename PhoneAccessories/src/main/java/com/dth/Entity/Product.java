package com.dth.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int product_id;
    String product_name;
    String product_price;
    String description_product;
    String product_image;
    
    /**
     * a product with many details
     */
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    Set<Product_Details> product_Details;
    
    @OneToOne
    @JoinColumn(name = "category_id")
    Product_Category product_Category;
    
    /**
     * One product for many promotions
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Promotion_Details",
    joinColumns = {@JoinColumn(name ="product_id",referencedColumnName = "product_id")},
    inverseJoinColumns = {@JoinColumn(name="promotion_id",referencedColumnName = "promotion_id")})
    Set<Product_Promotion> List_Of_Promotion;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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

	public Product_Category getProduct_Category() {
		return product_Category;
	}

	public void setProduct_Category(Product_Category product_Category) {
		this.product_Category = product_Category;
	}

	public Set<Product_Promotion> getList_Of_Promotion() {
		return List_Of_Promotion;
	}

	public void setList_Of_Promotion(Set<Product_Promotion> list_Of_Promotion) {
		List_Of_Promotion = list_Of_Promotion;
	}
    
    
    

}
