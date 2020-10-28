package com.madhuram.web.entities;

public class CartItem {
	public Integer ItemID;
	private String ItemName;
	private Double Quantity;
	private Double Price;
	private Double UnitCost;
	private String Category;
	public CartItem(String itemName, Double quantity, String category, Double unitCost, Integer id) {
		super();
		ItemName = itemName;
		Quantity = quantity;
		Category = category;
		UnitCost = unitCost;
		ItemID = id;
		Price = Quantity * UnitCost;
	}
	public String getItemName() {
		return ItemName;
	}
	public Double getQuantity() {
		return Quantity;
	}
	public Double getPrice() {
		return Price;
	}
	public Double getUnitCost() {
		return UnitCost;
	}
	public String getCategory() {
		return Category;
	}
	public Integer getItemID() {
		return ItemID;
	}
	public void setItemID(Integer itemID) {
		ItemID = itemID;
	}
}
