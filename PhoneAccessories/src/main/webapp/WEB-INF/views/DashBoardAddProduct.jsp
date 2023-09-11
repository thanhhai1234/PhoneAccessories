<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp" />
<link rel="stylesheet" href="<c:url value = "/resources/css/Admin.css"/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<div id="mySidenav" class="sidenav">
		<p class="logo">
			<span>TOP</span>CITY
		</p>
		<a href="#" class="icon-a"><i class="fa fa-dashboard icons"></i>&nbsp;&nbsp;Dashboard</a> 
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
					class="nav"> DashBoard Add Product</span> 
			</div>
		</div>
		
		
		<div class="container">
			<div class="row">
				
				<div class="col-md-6 col-sm-12 form-group">
					<form id="getProductData" action="">
						<label for="product_name">Product Name</label></br> 
						<input name="product_name" type="text" id="productName" class="form-control" placeholder="Enter the product name" /></br> 
						
						<label for="product_price">Product Pricing</label></br> 
						<input name="product_price" type="text" id="itemPrice" class="form-control" placeholder="Enter the price" /></br> 
						
						<label for="product_Category">Select The Product Category</label> 
						<select name="product_Category" class="form-control" id="selectCategory">
							<c:forEach var="value" items="${categories}">
								<option value="${value.getCategory_id()}">${value.getCategory_name()}</option>
							</c:forEach>
						</select></br> 
						
						<label for="description_product">Product Description</label>
						<textarea name="description_product" rows="4" id="description" class="form-control" placeholder="Enter in the description"></textarea></br> 
						
						<label for="product_image">Product Photos</label></br> 
						<input name="product_image" enctype="multipart/form-data" type="file" id="productPhotos" class="form-control" placeholder="Enter the price" /></br>

						<div id="container-detailProducts">
							<div class="detailProducts">
								<p>product details</p>
								<select name="productColor" class="form-control"
									id="productColor">
									<c:forEach var="value" items="${listColor}">
										<option value="${value.getColor_id()}">${value.getColor_name()}</option>
									</c:forEach>
								</select></br> <input min="1" value="1" name="numberOfProduct" type="number"
									id="numberOfProduct" class="form-control"
									placeholder="Enter the number of products" /></br>
								<button class="btn-detailproduct btn btn-warning">Add Detail Product</button>
							</div>
						</div>

						<div id="detailProducts" class="detailProducts">
							<span>product details</span> 
							<select name="productColor" class="form-control" id="productColor">
								<c:forEach var="value" items="${listColor}">
									<option value="${value.getColor_id()}">${value.getColor_name()}</option>
								</c:forEach>
							</select></br> 
							<input min="1" value="1" name="numberOfProduct" type="number" id="numberOfProduct" class="form-control" placeholder="Enter the number of products" /></br>
							
							<button class="btn-detailproduct btn btn-warning">Add Detail Product</button>
						</div>

						<button id="btn-addProduct" class="btn btn-success">Add Product</button>
						<button id="btn-ProductUpdate" class="hidden btn btn-success">Update</button>
						<button id="btn-exits" class="hidden btn btn-success">Exits</button>
					</form>
				</div>
			
			
				
				<div class="col-md-6 col-sm-12">
					<div class="col-div-12" style="float: right; margin: 10px 0px;">
						<button id="delete-product" class="btn btn-danger">Delete</button>
					</div>
					<div class="col-div-12">
						<table id="change-table" class="table">
							<thead>
								<tr style="background-color: #00483d; font-weight: 700;">
									<td>
										<div class="checkbox">
											<label><input id="check-all" type="checkbox" /></label>
										</div>
									</td>
									<td>Product Name</td>
									<td>Price</td>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="value" items="${ListProducts}">
									<tr>
										<td>
											<div class="checkbox">
												<label><input class="checkboxProduct" type="checkbox" value="${value.getProduct_id()}" /></label>
											</div>
										</td>
										<td style="color: black;" class="" data-Id="${value.getProduct_id()}">${value.getProduct_name()}</td>
										<td style="color: black;" class="">${value.getProduct_price()}</td>
										<td class="productUpdate" data-id="${value.getProduct_id()}">Update</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<nav aria-label="...">
							<ul class="pagination pagination-sm">
								<c:forEach var="i" begin="1" end="${AllPage}">
									<c:choose>
										<c:when test="${i == 1}">
											<li class="page-item active"><a  class="page-link" href="#">${i}</a></li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a  class="page-link" href="#">${i}</a></li>
										</c:otherwise>

									</c:choose>

									<c:if test="">

									</c:if>

								</c:forEach>
							</ul>
						</nav>
					</div>

				</div>
				
				
			</div>
				
				
				
		</div>


			
	</div>


		
	


	<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
	<jsp:include page="footer.jsp" />
</body>
</html>