package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Creation 
{
	
	private int sku;
	private String itemName;
	private String itemDescription;
	private int quantity;
	
	public Creation()
	{
		
	}
	
	public Creation(int sku, String itemName, String itemDescription, int quantity)
	{
		this.sku = sku;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.quantity = quantity;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}