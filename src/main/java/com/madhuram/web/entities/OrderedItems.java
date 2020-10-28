package com.madhuram.web.entities;

public class OrderedItems {
	private Integer ItemID;
	private Integer OrderID;
	private Double Qty;
	
	public Integer getItemID() {
		return ItemID;
	}
	public void setItemID(Integer itemID) {
		ItemID = itemID;
	}
	public Integer getOrderID() {
		return OrderID;
	}
	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}
	public Double getQty() {
		return Qty;
	}
	public void setQty(Double qty) {
		Qty = qty;
	}
	
}
