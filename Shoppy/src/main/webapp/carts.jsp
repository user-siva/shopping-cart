<%@ page import="java.util.*" %>
<%@ page import="com.shoppy.dao.ProductDao" %>
<%@ page import="com.shoppy.connection.DBCon" %>
<%@ page import="com.shoppy.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProducts = null;

if(cartList!=null)
{
	ProductDao pdao = new ProductDao(DBCon.getConnection());
	cartProducts = pdao.getCartProducts(cartList);
	request.setAttribute("cart_list",cartList);
	
	int totalPrice = pdao.getTotalPrice(cartList);
	request.setAttribute("totalPrice", totalPrice);
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<%@include file="includes/head.jsp" %>
<style type="text/css">

.table tbody td
{
vertical-align:middle;
}

.btn-incre, .btn-decre
{
box-shadow:none;
fornt-size:25px;
}

</style>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<div class="container">
<div class="d-flex py-3">
<h3>Total Price: $ ${ totalPrice }</h3>
<a class="mx-3 btn btn-primary" href="#">Check Out</a>
</div>
<table class="table table-loght">
<thead>
<tr>
<th scope="col">Name:</th>
<th scope="col">Category:</th>
<th scope="col">Price:</th>
<th scope="col">Buy Now:</th>
<th scope="col">Cancel:</th>
</tr>
</thead>
<tbody>
<% 
if(cartProducts!=null)
{
	for(Cart c:cartProducts)
	{%>
		<tr>
		<td><%= c.getName() %></td>
		<td><%= c.getCategory() %></td>
		<td><%= c.getPrice() %></td>
		<td>
		<form action="buy-now" method="post" class="form-inline">
		<input type="hidden" name="id" value="1" class="form-input">
		<div class="form-group d-flex justify-content-between w-50">
		<a class="btn btn-sm btn-incre" href="update-quantity?action=dec&id=<%= c.getId() %>"><i class="fas fa-minus-square"></i></a>
		<input type="text" name="quantity" class="form-control w-50" value="<%= c.getQuantity() %>" readonly>
		<a class="btn btn-sm btn-decre" href="update-quantity?action=inc&id=<%= c.getId() %>"><i class="fas fa-plus-square"></i></a>
		<button class="btn btn-primary btn-sm">Buy</button>
		</div>
		</form>
		</td>
		<td><a class="btn btn-sm btn-danger" href="remove-from-cart?id=<%= c.getId() %>">Remove</a></td>
		</tr>
	<%}
}
	
%>
</tbody>
</table>
</div>


<%@include file="includes/footer.jsp" %>
</body>
</html>