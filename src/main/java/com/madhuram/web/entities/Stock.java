package com.madhuram.web.entities;

public class Stock{
	private Integer StockID;
	private Double Quantity;
	private java.time.LocalDate DateIn;
	private Integer ShopID;
	private Integer ItemID;
	public Integer getStockID() {
		return StockID;
	}
	public void setStockID(Integer stockID) {
		StockID = stockID;
	}
	public Double getQuantity() {
		return Quantity;
	}
	public void setQuantity(Double quantity) {
		Quantity = quantity;
	}
	public java.time.LocalDate getDateIn() {
		return DateIn;
	}
	public void setDateIn(java.time.LocalDate dateIn) {
		DateIn = dateIn;
	}
	public Integer getShopID() {
		return ShopID;
	}
	public void setShopID(Integer shopID) {
		ShopID = shopID;
	}
	public Integer getItemID() {
		return ItemID;
	}
	public void setItemID(Integer itemID) {
		ItemID = itemID;
	}

	
}