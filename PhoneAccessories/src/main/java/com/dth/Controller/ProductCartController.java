package com.dth.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dth.Entity.Invoice;
import com.dth.Entity.Invoice_Details;
import com.dth.Entity.Invoice_Details_Id;
import com.dth.Entity.ProductCart;
import com.dth.Service.InvoiceDetailsService;
import com.dth.Service.InvoiceService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("cart/")
public class ProductCartController {
	
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	InvoiceDetailsService invoiceDetailsService;
	
	@GetMapping
	public String Default(HttpSession httpSession,ModelMap map) {
		
		if(httpSession.getAttribute("cart") != null) {
			List<ProductCart> productCarts = (List<ProductCart>) httpSession.getAttribute("cart");
			map.addAttribute("NumberOfProduct", productCarts.size());
			map.addAttribute("ListProductCarts", productCarts);
		}
		
		return "ProductCart";
		
	}
	
	@PostMapping
	public String AddInvoice(HttpSession httpSession, @RequestParam String customer_name,@RequestParam String phone_number,@RequestParam String delivery_address,@RequestParam String delivery_method,@RequestParam String note) {
		
		if(httpSession.getAttribute("cart") != null) {
			List<ProductCart> productCarts = (List<ProductCart>) httpSession.getAttribute("cart");
			Invoice invoice = new Invoice();
			invoice.setCustomer_name(customer_name);
			invoice.setPhone_number(phone_number);
			invoice.setDelivery_address(delivery_address);
			invoice.setDelivery_method(delivery_method);
			invoice.setNote(note);
			
			
			int invoiceId = invoiceService.addInvoice(invoice);
			
			if(invoiceId > 0) {
				Set<Invoice_Details> ListInvoiceDetails = new HashSet<Invoice_Details>();
				for (ProductCart productCart : productCarts) {
					Invoice_Details_Id invoice_Details_Id = new Invoice_Details_Id();
					invoice_Details_Id.setProduct_details_id(productCart.getProductDetails_id());
					invoice_Details_Id.setInvoice_id(invoice.getInvoice_id());
					
					Invoice_Details invoice_Details = new Invoice_Details();
					invoice_Details.setInvoice_Details_Id(invoice_Details_Id);
					invoice_Details.setProduct_price(productCart.getPrice());
					invoice_Details.setQuantity(productCart.getQuantity());
					
					invoiceDetailsService.addInvoiceDetail(invoice_Details);
					
					}
				
			}else {
				System.out.println("them tb");
				
			}	
		}
		
		
		
		return"ProductCart";
	}

}
