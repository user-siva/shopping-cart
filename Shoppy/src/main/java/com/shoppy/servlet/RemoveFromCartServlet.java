package com.shoppy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.shoppy.model.Cart;


public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter())
		{	
			response.setContentType("text/html;charset=UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));
			if(id>=0)
			{
				ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
				if(cartList != null)
				{
					for(Cart c:cartList)
					{
						if(c.getId()==id)
						{ 
							cartList.remove(cartList.indexOf(c));
							break;
						}
					}
					response.sendRedirect("carts.jsp");
				}
			}
			else
			{
				response.sendRedirect("carts.jsp");
			}
		}
	}

}
