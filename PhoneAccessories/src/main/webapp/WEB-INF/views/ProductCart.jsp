<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top city</title>
<jsp:include page="header.jsp" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
</head>
<body>
	<section id="detail-page">

		<nav>
			<div id="check" class="logo">
				<img id="image-logo" src='<c:url value="/resources/Image/YOP.png"/>' />
			</div>
			<ul>
				<li><a href="/PhoneAccessories/">Home</a></li>
				<li><a href="#Products">Products</a></li>
				<li><a href="#Servises">Servises</a></li>
			</ul>
			 
			<div class="icons">
			<a id="cart-a">
				<i id="addQuantity" class="fa-solid fa-cart-shopping">
				<c:if test="${NumberOfProduct > 0}">
					<div id="cart-number"><span>${NumberOfProduct}</span></div>
				</c:if>
				<c:if test="${NumberOfProduct <=0 || NumberOfProduct == null }">
					<div id="cart-number"><span>0</span></div> 
				</c:if>

				</i>
			</a>
			
				
				
				
				<c:choose>
					<c:when test="${fc != null}">
						<a id="first-char" href="#"> ${fc} </i></a>
					</c:when>
					<c:otherwise>
						<a href="#"><i class="fa-solid fa-user"></i></a>
					</c:otherwise>
				</c:choose>

			</div>

		</nav>


	</section>
	
	<!-- Detail Product -->
	
	<div id="container-detail" class="container">
		<div class="row">
			<div class="col-md-6 col-sm-12">
			<h4>Product List</h4>
				<table class="table">
					<thead>
						<tr>
							<td>Picture</td>
							<td>name</td>
							<td>Color</td>
							<td>Quantity</td>
							<td>Price</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="value" items="${ListProductCarts}">
							<tr data-detailsId ="${value.getProductDetails_id()}">
								<td align="center"><img id="image-productDetail" src='<c:url value="${value.getPath_image()}"/>' /></td>
								<td class="product-id " data-Id ="${value.getProduct_id()}">${value.getProduct_name()}</td>
								<td class="color center-td" data-color="${value.getColor_id()}">${value.getColor_name()}</td>
								<td class="quantity center-td" data-quantity="${value.getQuantity()}"><input class="scale-input" type="number" min="1" value="${value.getQuantity()}" /></td>
								<td class="price-product center-td" data-value="${value.getPrice()}">${value.getPrice()}</td>
								<td class="btn btn-danger delete-product">delete</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h5>Total cost: <span id="total-cost" style="color:red">0VND</span></h5>
			</div>
			<div class="col-md-6 col-sm-12">
			<h4>Information from the purchasers</h4>
				<div class="form-group">
				<form action="" method="post">
					<label for="customer_name">Name</label>
					<input class="form-control" id="customer_name" name="customer_name"/></br>
					
					<label for="phone_number">Phone Number</label>
					<input class="form-control" id="phone_number" name="phone_number"/>
						<div id="borderline-checkbox">
							<div class="radio">
								<label><input checked="checked" type="radio" name="delivery_method" value="Door-to-door delivery service"/>Door-to-door delivery service</label>
							</div>
							<div class="radio">
								<label><input type="radio" name="delivery_method" value="Buy at the store" />Buy at the store</label>
							</div>
						</div>
					<label for="delivery_address">Delivery address</label>
					<input class="form-control" id="delivery_address" name="delivery_address"/></br>
					
					<label for="note">Comments</label>
					<textarea rows="4" class="form-control" name="note"></textarea></br>
					
					<input type="submit" class="btn btn-success" value="Order"/>
				</form>
				</div>
			</div>
		</div>

	</div>


	<!--Footer-->

	<footer>
		<div class="footer_main">
			<div class="tag">
				<h1>Contact</h1>
				<a href="#"><i class="fa-solid fa-house"></i>123 - Ha Noi</a> 
				<a href="#"><i class="fa-solid fa-phone"></i>0999 999 999</a> 
				<a href="#"><i class="fa-solid fa-envelope"></i>topcity@gmail.com</a>
			</div>

			<div class="tag">
				<h1>Get Help</h1>
				<a href="#" class="center">FAQ</a> <a href="#" class="center">Shipping</a>
				<a href="#" class="center">Returns</a> <a href="#" class="center">Payment Options</a>
			</div>

			<div class="tag">
				<h1>Our Stores</h1>
				<a href="#" class="center">Ha Noi</a> 
				<a href="#" class="center">TP Ho Chi Minh</a>
				<a href="#" class="center">Da Nang</a> 
				<a href="#" class="center">Can Tho</a>
			</div>

			<div class="tag">
				<h1>Follw Us</h1>
				<div class="social_link">
					<a href="#"><i class="fa-brands fa-facebook-f"></i></a> 
					<a href="#"><i class="fa-brands fa-twitter"></i></a>
					<a href="#"><i class="fa-brands fa-instagram"></i></a>
					<a href="#"><i class="fa-brands fa-linkedin-in"></i></a>
				</div>
			</div>
			
			<div class="tag">
				<h1>For FeedBack</h1>
				<div class="search_bar">
					<input type="text" placeholder="Enter the review">
					<button type="submit">Submit</button>
				</div>
			</div>

		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
	<jsp:include page="footer.jsp" />
</body>
</html>