package com.madhuram.web.entities;

import org.springframework.stereotype.Repository;

@Repository
public class Cart {
	private Integer UserID;
	private Integer ItemID;
	private Double Qty;

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

	public Double getQty() {
		return Qty;
	}

	public void setQty(Double qty) {
		Qty = qty;
	}

	public Integer getItemID() {
		return ItemID;
	}

	public void setItemID(Integer itemID) {
		ItemID = itemID;
	}

	@Override
	public String toString() {
		return "Cart [UserID=" + UserID + ", ItemID=" + ItemID + ", Qty=" + Qty + "]";
	}
	

}
