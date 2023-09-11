package com.dth.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dth.DAO.InvoiceDAO;
import com.dth.Entity.Invoice;
import com.dth.Imp.InvoiceImp;

@Service
public class InvoiceService implements InvoiceImp {
	
	@Autowired
	InvoiceDAO invoiceDAO;

	public int addInvoice(Invoice invoice) {
		
		return invoiceDAO.addInvoice(invoice);
	}

}
