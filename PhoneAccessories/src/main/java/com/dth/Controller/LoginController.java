package com.dth.Controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dth.Entity.Employee;
import com.dth.Service.EmployeeService;


@Controller
@RequestMapping("login/")
public class LoginController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String Default() {
		
		return "Login";
	}
	
	@PostMapping
	public String Resgister(@RequestParam String email, @RequestParam String password,@RequestParam String reEnterPass,ModelMap map) {
		boolean checkEmail= validate(email);
		if(checkEmail) {
			if(password.equals(reEnterPass)) {
				Employee emp = new Employee();
				emp.setEmployee_email(email);
				emp.setLogin_name(email);
				emp.setEmployee_password(password);
				
				Boolean checkRes = employeeService.AddRegistration(emp);
				if(checkRes) {
					map.addAttribute("createAccount", "Account successfully created");
				}
			}else {
				map.addAttribute("reTypePass", "Password does not match");
			}
		}else {
			map.addAttribute("checkMail", "please type right your email formats");
		}
		return "Login";
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.matches();
	}
	
	
}
