////////////////////////////////////////////////////////////////////
// Enrico Cancelli 1143080
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
	public enum itemType{
		Pizza,Primo
	}
	private itemType type;
	private String name;
	private double price;
	public MenuItem(itemType type,String name,double price) {
		this.type=type;
		this.name=name;
		this.price=price;
	}
	public itemType getType() {return type;}
	public String getName() {return name;}
	public double getPrice() {return price;}
}
