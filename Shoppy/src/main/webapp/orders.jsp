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

<%@include file="includes/footer.jsp" %>
</body>
</html>