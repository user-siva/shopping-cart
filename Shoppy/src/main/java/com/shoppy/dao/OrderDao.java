package com.shoppy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.shoppy.model.Order;

public class OrderDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrderDao(Connection con)
	{
		this.con = con;
	}
	
	public boolean insertOrder(Order order)
	{
		boolean res = false;
		
		try
		{
			
			query = "Insert into orders (o_id,u_id,o_quantity,o_date) values (?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getUid());
			pst.setInt(3, order.getQuantity());
			pst.setString(4, order.getDate());
			pst.executeUpdate();
			res = true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	}
}
