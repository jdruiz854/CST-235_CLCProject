package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.Creation;

@ManagedBean
@ViewScoped
public class DatabaseService 
{
	
	public String getAllOrders() throws SQLException
	{
	
		String url = "jdbc:postgresql://localhost:5432/postgres"; //these are placeholders until the next milestone
		String username = "postgres";
		String password = "Tetelestai";
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Success!");		
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("Select * from testapp.orders");
			
			while (rs.next())
		{
			System.out.println("id = " + rs.getInt("id") + " Order Numbre: " + rs.getString("order_no") + " Product Name: " + rs.getString("product_name") + " Price: " + 
								rs.getString("price") + " Quantity: " + rs.getString("quantity"));
		}
			
			
		} 
			catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Failure!");
			
			return "viewAll";
		} 
		finally
		{
			rs.close();
			stmt.close();
			conn.close();
		}
		return "viewAll";
	}
	
	public int deleteItem(int sku) throws SQLException
	{
		String url = "jdbc:postgresql://localhost:5432/postgres"; //these are placeholders until the next milestone
		String username = "postgres";
		String password = "Tetelestai";
	
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Success!");		
			
			stmt = conn.prepareStatement("delete from testapp.items where sku = ?");
			stmt.setInt(1, sku);
			
			rows = stmt.executeUpdate();
			
			System.out.println("Rows Affected: " + rows);
			
		} 
			catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Failure!");

		} 
		finally
		{
			stmt.close();
			conn.close();
		}
		return rows;

	}
	
	public int updateItem(int sku, Creation c) throws SQLException
	{
		String url = "jdbc:postgresql://localhost:5432/postgres"; //these are placeholders until the next milestone
		String username = "postgres";
		String password = "Tetelestai";
	
		Connection conn = null;
		Statement stmt = null;
		int rows = 0;
		
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Success!");		
			
			stmt = conn.createStatement();
			
			rows = stmt.executeUpdate("update testapp.items set 'item_name' = 'New Item Added' where sku = 0001");
			
			System.out.println("Rows Affected: " + rows);
			
			
		} 
			catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Failure!");

		} 
		finally
		{
			stmt.close();
			conn.close();
		}
		return rows;
				
	}
	
	public int insertItem(Creation c) throws SQLException
	{
		
		String url = "jdbc:postgresql://localhost:5432/postgres"; //these are placeholders until the next milestone
		String username = "postgres";
		String password = "Tetelestai";
	
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Success!");		
			
			stmt = conn.prepareStatement("insert into testapp.items (sku, item_name, item_description, quantity) values (?,?,?,?)");
			stmt.setInt(1, c.getSku());
			stmt.setString(1, c.getItemName());
			stmt.setString(1,c.getItemDescription());
			stmt.setInt(1, c.getQuantity());
			
			rows = stmt.executeUpdate();
			
			System.out.println("Rows Affected: " + rows);
			
			
		} 
			catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Failure!");

		} 
		finally
		{
			stmt.close();
			conn.close();
		}
		
		return rows;
		
	}
}
