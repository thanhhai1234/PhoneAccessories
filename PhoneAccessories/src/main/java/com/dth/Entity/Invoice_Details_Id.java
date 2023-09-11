package com.dth.Entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Invoice_Details_Id implements Serializable {
	
	int invoice_id;
    int Product_details_id;
    
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public int getProduct_details_id() {
		return Product_details_id;
	}
	public void setProduct_details_id(int product_details_id) {
		Product_details_id = product_details_id;
	}
    
    
}
