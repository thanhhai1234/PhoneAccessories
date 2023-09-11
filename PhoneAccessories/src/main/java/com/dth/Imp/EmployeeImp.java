package com.dth.Imp;

import com.dth.Entity.Employee;

public interface EmployeeImp {
	boolean CheckLogin(String employee_email,String employee_password);
	boolean AddRegistration(Employee employee);

}
