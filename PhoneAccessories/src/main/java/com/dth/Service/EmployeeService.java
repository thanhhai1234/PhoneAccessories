package com.dth.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dth.DAO.EmployeeDAO;
import com.dth.Entity.Employee;
import com.dth.Imp.EmployeeImp;

@Service
public class EmployeeService implements EmployeeImp {
	@Autowired
	EmployeeDAO employeeDAO;

	public boolean CheckLogin(String employee_email, String employee_password) {
		boolean check = employeeDAO.CheckLogin(employee_email, employee_password);
		return check;
	}

	public boolean AddRegistration(Employee employee) {
		boolean checkRegister = employeeDAO.AddRegistration(employee);
		return checkRegister;
	}

	
	

}
