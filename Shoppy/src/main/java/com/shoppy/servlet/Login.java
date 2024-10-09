package com.shoppy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.shoppy.connection.DBCon;
import com.shoppy.dao.UserDao;
import com.shoppy.model.User;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter())
		{
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			try
			{
				UserDao udao = new UserDao(DBCon.getConnection());
				User user = udao.userLogin(email, password);
				
				if(user!=null)
				{
					request.getSession().setAttribute("auth", user);
					response.sendRedirect("home.jsp");
				}
				else
				{
					out.print("Login Failed");
				}
			}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
