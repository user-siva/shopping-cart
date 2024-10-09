package com.shoppy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.shoppy.model.Cart;

public class AddProductToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductToCart() {};

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			ArrayList<Cart> cartList = new ArrayList<>();
			
			int id = Integer.parseInt(request.getParameter("id"));
			Cart cart = new Cart();
			cart.setId(id);
			cart.setQuantity(1);
			
			HttpSession session = request.getSession();
			
			ArrayList<Cart> cartSession = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			if(cartSession==null)
			{
				cartList.add(cart);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("home.jsp");
			}
			else
			{
				cartList = cartSession;
				boolean exist = false;
				for(Cart c:cartList)
				{
					if(c.getId()==id)
					{
						exist = true;
						out.print("<h3 style='color:crimson;text-align:center'>Product already exists in Cart <a href='carts.jsp'>Go to Cart</a></h3>.");
					}
				}
				if(!exist)
				{
					cartList.add(cart);
					session.setAttribute("cart-list", cartList);
					response.sendRedirect("home.jsp");
				}
			}
		}
		
	}

}
