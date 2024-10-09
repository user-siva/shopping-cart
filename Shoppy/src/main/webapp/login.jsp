<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.shoppy.model.Cart" %>

<% 

ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");

if(cartList!=null)
{
	request.setAttribute("cart_list",cartList);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
<div class="card w-50 mx-auto my-5">
<div class="card-header text-center">User Login</div>
<div class="card-body">
<form action="user-login" method="post">

<div class="form-group mt-4">
<label>Email Address:</label>
<input type="email" class="form-control" name="login-email" placeholder="Enter your Email" required>
</div>

<div class="form-group mt-4">
<label>Password:</label>
<input type="password" class="form-control" name="login-password" placeholder="Enter your Password" required>
</div>

<div class="text-center mt-4">
<button type="submit" class="btn btn-primary">Login</button>
</div>

</form>
</div>
</div>	
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>