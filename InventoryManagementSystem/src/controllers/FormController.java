package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Creation;

@ManagedBean
@ViewScoped
public class FormController 
{
	public String onSubmitEdit()
	{
		//when the user creates a new item
		
		
		//read the "get" values from the form
		FacesContext context = FacesContext.getCurrentInstance();
		Creation a = context.getApplication().evaluateExpressionGet(context, "#{creation}", Creation.class);
		
		System.out.println("The object entered is " + a.getSku());
		//store the "get" values in an object
		
		
		//put the get values into a response page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("creation", a);
		
		//show the response page.
		return "ResponsePage.xhtml";
	}
}
