package com.madhuram.web.entities;

public class Promocodes {
	private Integer PromoID;
	private Integer PromoPercentage;
	private String Promocode;
	private java.time.LocalDateTime PromoStartTime;
	private java.time.LocalDateTime PromoEndTime;
	private String ExpiredMessage;
	private String AcceptedMessage;
	private String PromoDescription;
	
	
	public Integer getPromoPercentage() {
		return PromoPercentage;
	}
	public void setPromoPercentage(Integer promoPercentage) {
		PromoPercentage = promoPercentage;
	}
	public String getPromoDescription() {
		return PromoDescription;
	}
	public void setPromoDescription(String promoDescription) {
		PromoDescription = promoDescription;
	}
	public Integer getPromoID() {
		return PromoID;
	}
	public void setPromoID(Integer promoID) {
		PromoID = promoID;
	}
	public String getPromocode() {
		return Promocode;
	}
	public void setPromocode(String promocode) {
		Promocode = promocode;
	}
	public java.time.LocalDateTime getPromoStartTime() {
		return PromoStartTime;
	}
	public void setPromoStartTime(java.time.LocalDateTime promoStartTime) {
		PromoStartTime = promoStartTime;
	}
	public java.time.LocalDateTime getPromoEndTime() {
		return PromoEndTime;
	}
	public void setPromoEndTime(java.time.LocalDateTime promoEndTime) {
		PromoEndTime = promoEndTime;
	}
	public String getExpiredMessage() {
		return ExpiredMessage;
	}
	public void setExpiredMessage(String expiredMessage) {
		ExpiredMessage = expiredMessage;
	}
	public String getAcceptedMessage() {
		return AcceptedMessage;
	}
	public void setAcceptedMessage(String acceptedMessage) {
		AcceptedMessage = acceptedMessage;
	}
	
	
	
}
