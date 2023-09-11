package com.dth.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int employee_id;
    String employee_name;
    String employee_address;
    String employee_sex;
    String employee_identification;
    String employee_email;
    String login_name;
    String employee_password;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    Position_Held position_Held;

    
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_address() {
		return employee_address;
	}

	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}

	public String getEmployee_sex() {
		return employee_sex;
	}

	public void setEmployee_sex(String employee_sex) {
		this.employee_sex = employee_sex;
	}

	public String getEmployee_identification() {
		return employee_identification;
	}

	public void setEmployee_identification(String employee_identification) {
		this.employee_identification = employee_identification;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	public Position_Held getPosition_Held() {
		return position_Held;
	}

	public void setPosition_Held(Position_Held position_Held) {
		this.position_Held = position_Held;
	}
    

}
