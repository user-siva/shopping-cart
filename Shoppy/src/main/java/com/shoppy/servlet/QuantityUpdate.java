package com.shoppy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import com.shoppy.model.Cart;

public class QuantityUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuantityUpdate() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter())
		{
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			
			ArrayList<Cart> cartList  = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			
			if(action!=null && id>=1)
			{
				if(action.equals("inc"))
				{
					for(Cart c:cartList)
					{
						if(c.getId()==id)
						{
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							break;
						}
					}
					response.sendRedirect("carts.jsp");
				}
				else if(action.equals("dec"))
				{
					for(Cart c:cartList)
					{
						if(c.getId()==id && c.getQuantity()>1)
						{
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							break;
						}
					}
					response.sendRedirect("carts.jsp");
				}
				else
				{
					response.sendRedirect("carts.jsp");
				}
			}
		}
		
	}

}
