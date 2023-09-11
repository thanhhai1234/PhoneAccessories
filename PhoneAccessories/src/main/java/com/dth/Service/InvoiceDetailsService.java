package com.dth.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dth.DAO.InvoiceDetailsDAO;
import com.dth.Entity.Invoice_Details;
import com.dth.Imp.InvoiceDetaisImp;

@Service
public class InvoiceDetailsService implements InvoiceDetaisImp {
	
	@Autowired
	InvoiceDetailsDAO invoiceDetailsDAO;

	public boolean addInvoiceDetail(Invoice_Details invoice_Details) {
		
		return invoiceDetailsDAO.addInvoiceDetail(invoice_Details);
	}

}
