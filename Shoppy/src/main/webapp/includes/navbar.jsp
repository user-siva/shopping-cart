<%@page import="com.shoppy.model.User" %>
<% User auth = (User) request.getSession().getAttribute("auth"); %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="home.jsp">Shoppy</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
        </li>
        <li class="nav-item">
	      <a class="nav-link" href="carts.jsp">Cart
	      <span class="badge bg-danger">${ cart_list.size() }</span></a>
	    </li>
        <%
        if(auth!=null)
        {%>
        	<li class="nav-item">
	          <a class="nav-link" href="orders.jsp">Orders</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="logout">Logout</a>
	        </li>
	        
        <% 
        }else{%>
        	<li class="nav-item">
	          <a class="nav-link" href="login.jsp">Login</a>
	        </li>
        <% } %>
      </ul>
    </div>
  </div>
</nav>