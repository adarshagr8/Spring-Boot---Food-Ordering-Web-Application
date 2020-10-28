package com.madhuram.web.entities;

public class Transactions {
	private String TransactionID;
	private String Invoice;
	private String BankTransactionID;
	private Double InvoiceAmount;
	private String Status;
	private String PaymentMethod;
	private Integer UserID;
	private java.time.LocalDateTime TransactionTime;
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}
	public Double getInvoiceAmount() {
		return InvoiceAmount;
	}
	public void setInvoiceAmount(Double invoiceAmount) {
		InvoiceAmount = invoiceAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public java.time.LocalDateTime getTransactionTime() {
		return TransactionTime;
	}
	public void setTransactionTime(java.time.LocalDateTime transactionTime) {
		TransactionTime = transactionTime;
	}
	public String getInvoice() {
		return Invoice;
	}
	public void setInvoice(String invoice) {
		Invoice = invoice;
	}
	public String getBankTransactionID() {
		return BankTransactionID;
	}
	public void setBankTransactionID(String bankTransactionID) {
		BankTransactionID = bankTransactionID;
	}
}
