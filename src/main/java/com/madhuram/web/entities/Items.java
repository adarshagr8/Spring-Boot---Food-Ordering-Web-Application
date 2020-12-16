package com.madhuram.web.entities;

public class Items{
	private Integer ItemID;
	private String ItemName;
	private Double ItemCost;
	private String ItemImage;
	private String ItemDescription;
	private Integer ExpiryDuration;
	private Double MaxAllowedQty;
	private Integer Enabled;
	private Integer MaxTemperature;
	private Integer MinTemperature;
	private Integer CategoryID;
	
	
	public String getItemImage() {
		return ItemImage;
	}
	public void setItemImage(String itemImage) {
		ItemImage = itemImage;
	}
	public String getItemDescription() {
		return ItemDescription;
	}
	public void setItemDescription(String itemDescription) {
		ItemDescription = itemDescription;
	}
	public Integer getItemID() {
		return ItemID;
	}
	public void setItemID(Integer itemID) {
		ItemID = itemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Double getItemCost() {
		return ItemCost;
	}
	public void setItemCost(Double itemCost) {
		ItemCost = itemCost;
	}
	public Integer getExpiryDuration() {
		return ExpiryDuration;
	}
	public void setExpiryDuration(Integer expiryDuration) {
		ExpiryDuration = expiryDuration;
	}
	public Double getMaxAllowedQty() {
		return MaxAllowedQty;
	}
	public void setMaxAllowedQty(Double maxAllowedQty) {
		MaxAllowedQty = maxAllowedQty;
	}
	public Integer getMaxTemperature() {
		return MaxTemperature;
	}
	public void setMaxTemperature(Integer maxTemperature) {
		MaxTemperature = maxTemperature;
	}
	public Integer getMinTemperature() {
		return MinTemperature;
	}
	public void setMinTemperature(Integer minTemperature) {
		MinTemperature = minTemperature;
	}
	public Integer getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(Integer categoryID) {
		CategoryID = categoryID;
	}
	
	public Integer getEnabled() {
		return Enabled;
	}
	public void setEnabled(Integer enabled) {
		Enabled = enabled;
	}
	@Override
	public String toString() {
		return "Items [ItemID=" + ItemID + ", ItemName=" + ItemName + ", ItemCost=" + ItemCost + ", ItemImage="
				+ ItemImage + ", ItemDescription=" + ItemDescription + ", ExpiryDuration=" + ExpiryDuration
				+ ", MaxAllowedQty=" + MaxAllowedQty + ", MaxTemperature=" + MaxTemperature + ", MinTemperature="
				+ MinTemperature + ", CategoryID=" + CategoryID + "]";
	}
	
	
	
	
	
}