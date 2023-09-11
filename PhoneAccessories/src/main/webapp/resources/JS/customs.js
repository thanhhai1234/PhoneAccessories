
function DropdownFunction() {
     document.querySelector(".content_dropdown").classList.toggle("show-up");
 }
 window.onclick = function(e) {
   if (!e.target.matches('.note_dropdown')) {
   var contentdropdown = document.querySelector(".content_dropdown");
     if (contentdropdown.classList.contains('show-up')) {
       contentdropdown.classList.remove('show-up');
     }
   }
 }

$(document).ready(function () {
	var productId = 0;

    $("#check-login").click(function () {
        email = $("#email").val();
        password = $("#password").val();
        $.ajax({
            url: "/PhoneAccessories/api/checklogin",
            type: "GET",
            data: {
                employee_email: email,
                employee_password: password,
            },
            success: function (value) {
                
                if (value == "true") {
                    path = window.location.href
                    newPath = path.replace("login/", "")
                    window.location = newPath;
                } else {
                    $(".login-failed").text("login failed")
                }
            }
        })
    });



    $(".cart-btn").click(function () {
		var Product_details_id = $(this).attr("data-detailsProduct");
        var product_id = $("#detail-title").attr("data-Id");
        var color_id = $(this).closest("tr").find(".color").attr("data-color");
        var quantity = $(this).closest("tr").find(".quantity").text();
        var product_name = $("#detail-title").text();
        var price = $("#detail-price").attr("data-value");
        var color_name = $(this).closest("tr").find(".color").text();
        var path_image = $("#image-detail").attr("data-image");
        $.ajax({
            url: "/PhoneAccessories/api/addtocart",
            type: "GET",
            data: {
				Product_details_id:Product_details_id,
                product_id: product_id,
                color_id: color_id,
                quantity: quantity,
                product_name: product_name,
                price: price,
                color_name: color_name,
                path_image:path_image
            },
            success: function (value) {
                $("#addQuantity").find("div").html("<span>" + value + "</span>");
            }
        })
    });
    
   
    shoppingCartTotal();
    function shoppingCartTotal(clickChange){
		 var totalCost = 0;
		 $(".price-product").each(function(){
		var price = $(this).text();
		var quantity = $(this).closest("tr").find(".quantity").attr("data-quantity");
		
		totals = parseInt(price) * quantity;
		
		var format =parseFloat(totals).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		totalCost = totalCost + totals;
		if(!clickChange){
			$(this).html(format);
		}
		
		var formatTotal = totalCost.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		$("#total-cost").html(formatTotal+"");
		
	});
	}
   
    
    $(".scale-input").change(function(){
		var quantity = $(this).val();
		var product_id = $(this).closest("tr").find(".product-id").attr("data-Id");
        var color_id = $(this).closest("tr").find(".color").attr("data-color");
		var price = $(this).closest("tr").find(".price-product").attr("data-value");
		var total = quantity * parseInt(price);
		var format = total.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		$(this).closest("tr").find(".price-product").html(format);
		shoppingCartTotal(true);
		$.ajax({
            url: "/PhoneAccessories/api/updatecartproduct",
            type: "GET",
            data: {
                product_id: product_id,
                color_id: color_id,
                quantity: quantity,
 
            },
            success: function (value) {
          
            }
        })
	});
	$(".delete-product").click(function (){
		var save = $(this);
		var product_id = $(this).closest("tr").find(".product-id").attr("data-Id");
		var color_id = $(this).closest("tr").find(".color").attr("data-color");
		$.ajax({
            url: "/PhoneAccessories/api/deleteproduct",
            type: "GET",
            data: {
                product_id: product_id,
                color_id: color_id,
 
            },
            success: function (value) {
          		save.closest("tr").remove();
          		shoppingCartTotal(true);
            }
        })
	});
	
	$("body").on("click",".page-item",function(){
		$(".page-item").removeClass("active");
		$(this).addClass("active");
		var numberOfText = $(this).text();
		var productnumber = (numberOfText -1)*5;
		
		$.ajax({
            url: "/PhoneAccessories/api/GetProductNumberOfPage",
            type: "GET",
            data: {
                productnumber: productnumber,
 
            },
            success: function (value) {
				
          		var tbodyProduct =  $("#change-table").find("tbody");
          		tbodyProduct.empty();
          		tbodyProduct.append(value);
          		
            }
        })
	});
	
	$("#check-all").change(function(){
		if(this.checked){
			$("#change-table input").each(function(){
			$(this).attr("checked",true);
		})
		}else{
			$("#change-table input").each(function(){
			$(this).attr("checked",false);
		})	
		}
	});
	
	$("#delete-product").click(function () {
		$("#change-table >tbody input:checked").each(function(){
			var productId = $(this).val();
			var deleteItself = $(this);
			
			$.ajax({
            url: "/PhoneAccessories/api/deleteProduct",
            type: "GET",
            data: {
                productId: productId,
 
            },
            success: function (value) {
				deleteItself.closest("tr").remove();
          		
            }
        })
		})
	});
	
	var files =[];
	var imageName ="";
	$("#productPhotos").change(function(event){
		files = event.target.files;
		imageName = files[0].name;
		forms = new FormData();
		forms.append("file",files[0]);
		
		$.ajax({
            url: "/PhoneAccessories/api/uploadfile",
            type: "POST",
            data:forms ,
            contentType:false,
            processData:false,
            enctype:"multipart/form-data",
            success: function (value) {	
            }
        })
	});
	
	$("body").on("click",".btn-detailproduct",function(){
		$(this).remove();
		var cloneDetail = $("#detailProducts").clone().removeAttr("id");
		$("#container-detailProducts").append(cloneDetail);
	});
	
	$("#btn-addProduct").click(function(event){
		event.preventDefault();
		var formData = $("#getProductData").serializeArray();
		json ={};
		arrayDetails = [];
		
		$.each(formData, function(i, field) {
			json[field.name] = field.value;
		});
		$("#container-detailProducts > .detailProducts").each(function() {
			objectDetails ={};
			var productColor = $(this).find('select[name="productColor"]').val();
			var numberOfProduct = $(this).find('input[name="numberOfProduct"]').val();
			objectDetails["productColor"] =productColor;
			objectDetails["numberOfProduct"] =numberOfProduct;
			
			arrayDetails.push(objectDetails);
		});
		
		json["product_Details"]=arrayDetails;
		json["product_image"] = imageName;
		console.log(json);
		
		
		$.ajax({
            url: "/PhoneAccessories/api/AddProductFromAdmin",
            type: "POST",
            data:{
				dataJson : JSON.stringify(json)
			} ,
            success: function (value) {	
            }
        })
		
	});
	
	$("#btn-ProductUpdate").click(function(event){
		event.preventDefault();
		var formData = $("#getProductData").serializeArray();
		json ={};
		arrayDetails = [];
		
		$.each(formData, function(i, field) {
			json[field.name] = field.value;
		});
		$("#container-detailProducts > .detailProducts").each(function() {
			objectDetails ={};
			var productColor = $(this).find('select[name="productColor"]').val();
			var numberOfProduct = $(this).find('input[name="numberOfProduct"]').val();
			objectDetails["productColor"] =productColor;
			objectDetails["numberOfProduct"] =numberOfProduct;
			
			arrayDetails.push(objectDetails);
		});
		json["productId"] = productId;
		json["product_Details"]=arrayDetails;
		json["product_image"] = imageName;
		console.log(json);
		
		$.ajax({
            url: "/PhoneAccessories/api/ProductUpdateAdmin",
            type: "POST",
            data:{
				dataJson : JSON.stringify(json)
			} ,
            success: function (value) {	
            }
        })
		
		
		
	});
	
	
	$("body").on("click",".productUpdate",function(){
		productId = $(this).attr("data-id");
		
		$("#btn-ProductUpdate").removeClass("hidden");
		$("#btn-exits").removeClass("hidden");
		$("#btn-addProduct").addClass("hidden");
		$.ajax({
            url: "/PhoneAccessories/api/GetProductListByIdAdmin",
            type: "POST",
            data:{
				product_id : productId
			} ,
            success: function (value) {
				console.log(value);	
				$("#productName").val(value.product_name);
				$("#itemPrice").val(value.product_price);
				$("#description").val(value.description_product);
				$("#selectCategory").val(value.product_Category.category_id);
				
				
				$("#container-detailProducts").html("");
				
				var countDetails = value.product_Details.length;
				for(i=0;i<value.product_Details.length;i++){
					var cloneDetail = $("#detailProducts").clone().removeAttr("id");
					if(i < countDetails - 1){
						cloneDetail.find(".btn-detailproduct").remove();
					}else{
						
					}
					
					cloneDetail.find("#productColor").val(value.product_Details[i].product_Color.color_id);
					cloneDetail.find("#numberOfProduct").val(value.product_Details[i].quantity);

					$("#container-detailProducts").append(cloneDetail);
				}
				
            }
        })
	});
	$("#btn-exits").click(function () {
		$("#btn-ProductUpdate").addClass("hidden");
		$(this).addClass("hidden");
		$("#btn-addProduct").removeClass("hidden");
	});
	
	
	


	


});