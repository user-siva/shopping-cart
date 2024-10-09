package com.shoppy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoppy.model.Cart;
import com.shoppy.model.Product;

public class ProductDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ProductDao(Connection con)
	{
		this.con = con;
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> products = new ArrayList<>();
		
		try
		{
			query = "SELECT * FROM products";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setImage(rs.getString("image"));
				p.setPrice(rs.getInt("price"));
				p.setCategory(rs.getString("category"));
				
				products.add(p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return products;
	}
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList)
	{
		List<Cart> products = new ArrayList<>();
		
		try
		{
			if(cartList.size()>0)
			{
				for(Cart c:cartList)
				{
					query = "SELECT * FROM products WHERE id=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1,c.getId());
					rs = pst.executeQuery();
					while(rs.next())
					{
						Cart cart = new Cart();
						cart.setId(rs.getInt("id"));
						cart.setName(rs.getString("name"));
						cart.setCategory(rs.getString("category"));
						cart.setImage(rs.getString("image"));
						cart.setPrice(rs.getInt("price")*c.getQuantity());
						cart.setQuantity(c.getQuantity());
						
						products.add(cart);
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return products;
	}
	
	public int getTotalPrice(ArrayList<Cart> cartList)
	{	
		int total = 0;
		
		try
		{
			if(cartList.size()>0)
			{
				for(Cart c:cartList)
				{
					query = "SELECT price FROM products WHERE id=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1,c.getId());
					rs = pst.executeQuery();
					
					while(rs.next())
					{
						total+=rs.getInt("price")*c.getQuantity();
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
	}
}
