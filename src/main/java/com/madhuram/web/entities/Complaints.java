package com.madhuram.web.entities;

public class Complaints {
	private Integer ComplaintID;
	private java.time.LocalDateTime RecordedTime;
	private String Subject;
	private String ComplaintMessage;
	private String Image;
	private Integer UserID;

	public Integer getComplaintID() {
		return ComplaintID;
	}

	public void setComplaintID(Integer complaintID) {
		ComplaintID = complaintID;
	}

	public java.time.LocalDateTime getRecordedTime() {
		return RecordedTime;
	}

	public void setRecordedTime(java.time.LocalDateTime recordedTime) {
		RecordedTime = recordedTime;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getComplaintMessage() {
		return ComplaintMessage;
	}

	public void setComplaintMessage(String complaintMessage) {
		ComplaintMessage = complaintMessage;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

}
