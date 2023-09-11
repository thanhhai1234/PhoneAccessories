<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top city</title>
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/PhoneAccessories/resources/css/Login.css">
</head>
<body>
	<div class="main">  	
		<input type="checkbox" id="chk" aria-hidden="true">

			<div class="signup">
					<label for="chk" aria-hidden="true">Login</label>
					<input id="email" type="email" name="employee_email" placeholder="Email">
					<input id="password" type="password" name="employee_password" placeholder="Password">
					<div class="login-failed">
						<span>${check_login}</span>
					</div>
					<button id="check-login">Login</button>
					
				
			</div>

			<div class="login">
				<form action="" method="post">
					<label for="chk" aria-hidden="true">Sign up</label>
					<input type="email" name="email" placeholder="Email address">
					<div class="login-failed">
						<span>${checkMail}</span>
					</div>
					<input id="password-register" type="password" name="password" placeholder="Password">
					<input type="password" name="reEnterPass" placeholder="Re-enter password">
					<div class="login-failed">
						<span>${reTypePass}${createAccount}</span>
					</div>
					<button id="sign-up">Sign up</button>
				</form>
			</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
	<jsp:include page="footer.jsp" />
</body>
</html>