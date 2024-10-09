package com.shoppy.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.shoppy.connection.DBCon;
import com.shoppy.dao.OrderDao;
import com.shoppy.model.Cart;
import com.shoppy.model.Order;
import com.shoppy.model.User;

public class BuyNow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter())
		{
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(0, 0, 0);
			
			User auth = (User) request.getSession().getAttribute("auth");
			if(auth!=null)
			{
				int id = Integer.parseInt(request.getParameter("id"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				Order orderModel = new Order();
				orderModel.setId(id);
				orderModel.setUid(auth.getId());
				orderModel.setQuantity(quantity);
				orderModel.setDate(format.format(date));
				
				OrderDao odao = new OrderDao(DBCon.getConnection());
				boolean res = odao.insertOrder(orderModel);
				
				if(res)
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
					}
					
					response.sendRedirect("home.jsp");
				}
				else
				{
					out.print("Order Failed!");
				}
				
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
