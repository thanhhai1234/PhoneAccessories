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
				<a href="/PhoneAccessories/"><img id="image-logo" src='<c:url value="/resources/Image/YOP.png"/>' /></a>
			</div>
			<ul>
				<li><a href="/PhoneAccessories/">Home</a></li>
				<li><a href="#Products">Products</a></li>
				<li><a href="#Servises">Servises</a></li>
			</ul>
			
			<div class="icons">
				<a id="cart-a" href="/PhoneAccessories/cart/"> 
					<i id="addQuantity" class="fa-solid fa-cart-shopping"> <c:if
							test="${NumberOfProduct > 0}">
							<div id="cart-number">
								<span>${NumberOfProduct}</span>
							</div>
						</c:if> <c:if test="${NumberOfProduct <=0 || NumberOfProduct == null }">
							<div id="cart-number">
								<span>0</span>
							</div>
						</c:if>

				</i>
				</a>




				<c:choose>
					<c:when test="${fc != null}">
						<a id="first-char" href="login/"> ${fc} </i></a>
					</c:when>
					<c:otherwise>
						<a href="/PhoneAccessories/login/"><i class="fa-solid fa-user"></i></a>
					</c:otherwise>
				</c:choose>

			</div>

		</nav>


	</section>
	
	<!-- Detail Product -->
	
	<div id="container-detail" class="container">
		<div class="row">
			<div id="product-category" class="col-sm-2 col-md-2">
			<div>
				<span id="product-category-titile">Product Catalogue</span>
			</div>
				<ul id="product-category-ul">
			
					<c:forEach var="category" items="${categories}">
						<li><a href="#">${category.getCategory_name()}</a></li>
					</c:forEach>
					
				</ul>
			</div>
			
			
			<div class="col-sm-8 col-md-8">
				<div class="row">
					<div class="col-sm-5 col-md-5">
						<img id="image-detail" data-image="/resources/Image/products/${product.getProduct_image()}" src='<c:url value="/resources/Image/products/${product.getProduct_image()}"/>' />
					</div>
					<div class="col-sm-7 col-md-7">
						<h4 id="detail-title" data-Id="${product.getProduct_id()}" >${product.getProduct_name()}</h4>
						<h5 id="detail-price" data-value="${product.getProduct_price()}" >${product.getProduct_price()}</h5>
						<table class="table">
							<thead>
								<tr>
									<td>Color</td>
									<td>Quantity</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="detailProduct" items="${product.getProduct_Details()}">
									<tr>
										<td class="color" data-color="${detailProduct.getProduct_Color().getColor_id()}" >${detailProduct.getProduct_Color().getColor_name()}</td>
										<td class="quantity" data-quantity="${detailProduct.getQuantity()}" >${detailProduct.getQuantity()}</td>
										<td><button  id="product-button" class="cart-btn" data-detailsProduct ="${detailProduct.getProduct_details_id()}">Add to cart</button></td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-2 col-md-2">
				<h5>Description</h5>
				<span>${product.getDescription_product()}</span>
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