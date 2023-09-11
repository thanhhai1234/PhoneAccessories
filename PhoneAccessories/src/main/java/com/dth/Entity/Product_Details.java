package com.dth.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "Product_Details")
public class Product_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Product_details_id;
    int quantity;
    String import_date;
    
    @OneToOne()
    @JoinColumn(name = "product_id")
    Product product;
    
    @OneToOne()
    @JoinColumn(name = "color_id")
    Product_Color product_Color;

	public int getProduct_details_id() {
		return Product_details_id;
	}

	public void setProduct_details_id(int product_details_id) {
		Product_details_id = product_details_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImport_date() {
		return import_date;
	}

	public void setImport_date(String import_date) {
		this.import_date = import_date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product_Color getProduct_Color() {
		return product_Color;
	}

	public void setProduct_Color(Product_Color product_Color) {
		this.product_Color = product_Color;
	}
    
    
}
