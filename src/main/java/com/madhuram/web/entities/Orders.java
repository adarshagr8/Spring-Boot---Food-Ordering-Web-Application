package com.madhuram.web.entities;

public class Orders {
	private Integer OrderID;
	private java.time.LocalDate OrderDate;
	private java.time.LocalTime OrderTime;
	private Double TotalQty;
	private Double Amount;
	private Double GST;
	private Double DeliveryCharge;
	private Double TotalAmount;
	private String Status;
	private String TransactionID;
	private Integer UserID;
	
	public Integer getOrderID() {
		return OrderID;
	}
	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}
	public java.time.LocalDate getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(java.time.LocalDate orderDate) {
		OrderDate = orderDate;
	}
	public java.time.LocalTime getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(java.time.LocalTime orderTime) {
		OrderTime = orderTime;
	}
	public Double getTotalQty() {
		return TotalQty;
	}
	public void setTotalQty(Double totalQty) {
		TotalQty = totalQty;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public Double getGST() {
		return GST;
	}
	public void setGST(Double gST) {
		GST = gST;
	}
	public Double getDeliveryCharge() {
		return DeliveryCharge;
	}
	public void setDeliveryCharge(Double deliveryCharge) {
		DeliveryCharge = deliveryCharge;
	}
	public Double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	@Override
	public String toString() {
		return "Orders [OrderID=" + OrderID + ", OrderDate=" + OrderDate + ", OrderTime=" + OrderTime + ", TotalQty="
				+ TotalQty + ", Amount=" + Amount + ", GST=" + GST + ", DeliveryCharge=" + DeliveryCharge
				+ ", TotalAmount=" + TotalAmount + ", Status=" + Status + ", TransactionID=" + TransactionID
				+ ", UserID=" + UserID + "]";
	}
	
	
}
