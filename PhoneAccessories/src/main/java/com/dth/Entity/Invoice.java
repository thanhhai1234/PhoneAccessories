package com.dth.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity(name = "Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int invoice_id;
    String customer_name;
    String phone_number;
    String delivery_address;
    String produc_status;
    String invoice_date;
    String delivery_method;
    String note;
    
    /**
     * One invoice with many details
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    Set<Invoice_Details> List_Of_Details;

    
	public String getDelivery_method() {
		return delivery_method;
	}

	public void setDelivery_method(String delivery_method) {
		this.delivery_method = delivery_method;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getProduc_status() {
		return produc_status;
	}

	public void setProduc_status(String produc_status) {
		this.produc_status = produc_status;
	}

	public String getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}

	public Set<Invoice_Details> getList_Of_Details() {
		return List_Of_Details;
	}

	public void setList_Of_Details(Set<Invoice_Details> list_Of_Details) {
		List_Of_Details = list_Of_Details;
	}
    
    
}
