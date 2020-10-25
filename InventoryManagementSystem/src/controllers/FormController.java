package controllers;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Creation;
import business.BusinessServiceInterface;
import database.DatabaseService;

@ManagedBean
@ViewScoped
public class FormController 
{
	@Inject
	BusinessServiceInterface services;
	
	public String onSubmitEdit() throws SQLException
	{
		FacesContext context = FacesContext.getCurrentInstance();
		
		Creation c = context.getApplication().evaluateExpressionGet(context, "#{creation}", Creation.class);
		
		System.out.println("New Item Added - Sku: " + c.getSku() + "Item Name: " + c.getItemName() + "Item Description: " + c.getItemDescription() + "Quantity: " + c.getQuantity());
		DatabaseService ds = new DatabaseService();
		ds.insertItem(c);
		
		//show the response page.
		return "viewAll.xhtml";
	}
	
	public String onDelete(Creation c) throws SQLException
	{
				
		System.out.println("The object to delete is " + c.getSku());
		//store the "get" values in an object
				
		DatabaseService ds = new DatabaseService();
		ds.deleteItem(c.getSku());
				
		//show the response page.
		return "viewAll.xhtml";
	}
	
	public BusinessServiceInterface getService()
	{
		return services;
	}
	
	public String onUpdate(int sku, Creation c) throws SQLException
	{
		System.out.println("The Object being updated is " + "Sku: " + c.getSku() + " Item Name: " + c.getItemName()+ "Item Description: " + c.getItemDescription()+ "Quanityt: " + c.getQuantity());
		DatabaseService ds = new DatabaseService();
		ds.updateItem(sku, c);
		
		return "viewAll.xhtml";
	}

}
