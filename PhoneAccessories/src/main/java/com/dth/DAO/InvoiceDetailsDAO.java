package com.dth.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dth.Entity.Invoice_Details;
import com.dth.Entity.Invoice_Details_Id;
import com.dth.Imp.InvoiceDetaisImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InvoiceDetailsDAO implements InvoiceDetaisImp {



	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addInvoiceDetail(Invoice_Details invoice_Details) {
		Session session = sessionFactory.getCurrentSession();
		Invoice_Details_Id id = (Invoice_Details_Id) session.save(invoice_Details);
		if(null != id ) {
			return true;
		}else {
			return false;
		}
		
	}

}
