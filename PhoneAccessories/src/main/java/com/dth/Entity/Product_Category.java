package com.dth.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity(name = "product_category")
public class Product_Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    String category_name;
    String category_image;
    
    @OneToMany
    @JoinColumn(name = "category_id")  
    Set<Product> List_Of_Product;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_image() {
		return category_image;
	}

	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}

	public Set<Product> getList_Of_Product() {
		return List_Of_Product;
	}

	public void setList_Of_Product(Set<Product> list_Of_Product) {
		List_Of_Product = list_Of_Product;
	}
    
    

}
