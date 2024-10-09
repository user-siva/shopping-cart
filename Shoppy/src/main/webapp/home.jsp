<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.shoppy.connection.DBCon" %>
<%@ page import="com.shoppy.dao.ProductDao" %>
<%@ page import="com.shoppy.model.Product" %>
<%@page import="java.util.*" %>
<%@page import="com.shoppy.model.Cart" %>

<% 

ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");

if(cartList!=null)
{
	request.setAttribute("cart_list",cartList);
}
%>

<%
ProductDao pd = new ProductDao(DBCon.getConnection());
List<Product> products = pd.getAllProducts();


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
	
<div class="container">
<div class="card-header my-3">All Products</div>
<div class="row">
<%
	if(!products.isEmpty())
	{
		for(Product p:products)
		{ %>
			<div class="col-md-3">
				<div class="card w-100" style="width: 18rem;">
				  <img src="product-images/men-suits.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				    <h5 class="card-title"><%= p.getName() %></h5>
				    <h6 class="price">Price: <%= p.getPrice() %></h6>
				    <h6 class="category">Category: <%= p.getCategory() %> </h6>
				    <div class="mt-3 d-flex justify-content-between">
				    	<a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-primary">Add to Cart</a>
				    	<a href="#" class="btn btn-danger">Buy Now</a>
				    </div>
				  </div>
				</div>
			</div>
		<%}
	}
%>
</div>
</div>
	
<%@include file="includes/footer.jsp" %>
</body>
</html>