package com.dth.Entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;


@Entity(name = "Invoice_Details")
public class Invoice_Details {
	
	@EmbeddedId
	Invoice_Details_Id invoice_Details_Id;
    int quantity;
    String product_price;
    
    
	public Invoice_Details_Id getInvoice_Details_Id() {
		return invoice_Details_Id;
	}
	public void setInvoice_Details_Id(Invoice_Details_Id invoice_Details_Id) {
		this.invoice_Details_Id = invoice_Details_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
    
    
}
