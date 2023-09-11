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
	<section>

		<nav>
			<div id="check" class="logo">
				<img id="image-logo" src='<c:url value="/resources/Image/YOP.png"/>' />
			</div>

			<ul>
				<li><a href="#Home">Home</a></li>
				<li><a href="#Products">Products</a></li>
				<li><a href="#Servises">Servises</a></li>
				<li>
					<div class="dropdown">
						<button onclick="DropdownFunction()" class="note_dropdown">Catalouge</button>
						<div class="content_dropdown">
							<c:forEach var="category" items="${categories}">
								<a href='<c:url value="/category/${category.getCategory_id()}/${category.getCategory_name()}"/>'>${category.getCategory_name()}</a>
							</c:forEach>
							
						</div>
					</div>
				</li>

			</ul>
			

			<div class="icons">
			<a id="cart-a" href="cart/">
				<i id="addQuantity" class="fa-solid fa-cart-shopping">
					<c:if test="${NumberOfProduct > 0}">
						<div id="cart-number">
							<span>${NumberOfProduct}</span>
						</div>
					</c:if> <c:if
						test="${NumberOfProduct <=0 || NumberOfProduct == null }">
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
						<a href="login/"><i class="fa-solid fa-user"></i></a>
					</c:otherwise>
				</c:choose>

			</div>

		</nav>
		
		


		<div class="main" id="Home">
			<div class="main_content">
				<div class="main_text">
					<h1>
						ACCESSORIES<br>
						<span>Collection</span>
					</h1>
					<p>Charge your phone or Galaxy Buds on one side and your Galaxy Watch on the other with Fast Wireless Charging.17</p>
				</div>
				<div class="main_image">
					<img src='<c:url value="/resources/Image/products/product_mouse1.png"/>' />
				</div>
			</div>
			<div class="social_icon">
				<i class="fa-brands fa-facebook-f"></i> <i
					class="fa-brands fa-twitter"></i> <i class="fa-brands fa-instagram"></i>
				<i class="fa-brands fa-linkedin-in"></i>
			</div>
			<div class="button">
				<a href="#">SHOP NOW</a> <i class="fa-solid fa-chevron-right"></i>
			</div>
		</div>

	</section>
	


	<!--Products-->

	<div class="products" id="Products">
		<h1>Products</h1>

		<div class="box">
			<c:forEach var="product" items="${ListProduct}">
				<div class="card">
				<a href="detailproduct/${product.product_id}">
					<div class="image">
						<img src='<c:url value="/resources/Image/products/${product.getProduct_image()}"/>'/>
					</div>

					<div class="products_text">
						<h2>${product.getProduct_name()}</h2>
						<h3>${product.getProduct_price()} <span>VND</span> </h3> 
						<div class="products_star">
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
					</div>
						
					</div>
				</a>
					
				</div>
			</c:forEach>
			
			
		</div>
	</div>





	<!--Services-->

	<div class="services" id="Servises">
		<h1>
			our<span>services</span>
		</h1>

		<div class="services_cards">
			<div class="services_box">
				<i class="fa-solid fa-truck-fast"></i>
				<h3>Fast Delivery</h3>
				
			</div>
			
			<div class="services_box">
				<i class="fa-solid fa-rotate-left"></i>
				<h3>10 Days Replacement</h3>
				
			</div>

			<div class="services_box">
				<i class="fa-solid fa-headset"></i>
				<h3>24 x 7 Support</h3>
				
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