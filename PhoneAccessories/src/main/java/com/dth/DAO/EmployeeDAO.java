package com.dth.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dth.Entity.Employee;
import com.dth.Imp.EmployeeImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeDAO implements EmployeeImp {


	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean CheckLogin(String employee_email, String employee_password) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Employee employee = (Employee) session.createQuery("from Employee where employee_email = '"+employee_email+"' AND employee_password='"+employee_password+"' ").getSingleResult();
			if(employee != null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Transactional
	public boolean AddRegistration(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		int employee_id = (Integer) session.save(employee);
		if(employee_id > 0) {
			return true;
		}else {
			return false;
		}
	}

	


}
