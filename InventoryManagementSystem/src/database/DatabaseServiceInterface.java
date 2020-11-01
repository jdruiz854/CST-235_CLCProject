package database;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.Creation;

public interface DatabaseServiceInterface 
{
	public int updateItem(int sku, Creation c) throws SQLException;
	public int insertItem(Creation c) throws SQLException;
	public int deleteItem(int sku) throws SQLException;
	public ArrayList<Creation> getAllOrders() throws SQLException;
}
