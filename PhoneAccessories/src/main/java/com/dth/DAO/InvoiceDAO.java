package com.dth.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dth.Entity.Invoice;
import com.dth.Imp.InvoiceImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InvoiceDAO implements InvoiceImp {


	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public int addInvoice(Invoice invoice) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(invoice);
		if(id > 0) {
			return id;
		}else {
			return 0;
		}
		
	}

}
