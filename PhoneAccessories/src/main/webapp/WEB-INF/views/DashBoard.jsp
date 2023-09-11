<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value = "/resources/css/Admin.css"/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<div id="mySidenav" class="sidenav">
		<p class="logo">
			<span>TOP</span>CITY
		</p>
		<a href="/PhoneAccessories/dashboardaddproduct/" class="icon-a"><i class="fa fa-dashboard icons"></i>&nbsp;&nbsp;Product</a> 
		<a href="#" class="icon-a"><i class="fa fa-users icons"></i>&nbsp;&nbsp;Customers</a>
		<a href="#" class="icon-a"><i class="fa fa-list icons"></i>&nbsp;&nbsp;Projects</a> 
		<a href="#" class="icon-a"><i class="fa fa-shopping-bag icons"></i>&nbsp;&nbsp;Orders</a>
		<a href="#" class="icon-a"><i class="fa fa-tasks icons"></i>&nbsp;&nbsp;Inventory</a> 
		<a href="#" class="icon-a"><i class="fa fa-user icons"></i>&nbsp;&nbsp;Accounts</a> 
		<a href="#" class="icon-a"><i class="fa fa-list-alt icons"></i>&nbsp;&nbsp;Tasks</a>

	</div>
	<div id="main">

		<div class="head">
			<div class="col-div-12">
				<span style="font-size: 30px;"
					class="nav"> DashBoard</span> 
			</div>
		</div>


		
	</div>


	<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
	<jsp:include page="footer.jsp" />
</body>
</html>