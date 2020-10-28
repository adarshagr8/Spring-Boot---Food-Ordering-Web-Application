package com.madhuram.web.entities;

public class Offers {
	private Integer OfferID;
	private Integer OfferPercentage;
	private java.time.LocalDateTime OfferStartTime;
	private java.time.LocalDateTime OfferEndTime;
	private String ExpiredMessage;
	private String AcceptedMessage;
	private String OfferDescription;
	
	
	public Integer getOfferPercentage() {
		return OfferPercentage;
	}
	public void setOfferPercentage(Integer offerPercentage) {
		OfferPercentage = offerPercentage;
	}
	public Integer getOfferID() {
		return OfferID;
	}
	public void setOfferID(Integer offerID) {
		OfferID = offerID;
	}
	public java.time.LocalDateTime getOfferStartTime() {
		return OfferStartTime;
	}
	public void setOfferStartTime(java.time.LocalDateTime offerStartTime) {
		OfferStartTime = offerStartTime;
	}
	public java.time.LocalDateTime getOfferEndTime() {
		return OfferEndTime;
	}
	public void setOfferEndTime(java.time.LocalDateTime offerEndTime) {
		OfferEndTime = offerEndTime;
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
	public String getOfferDescription() {
		return OfferDescription;
	}
	public void setOfferDescription(String offerDescription) {
		OfferDescription = offerDescription;
	}
	
	
}

