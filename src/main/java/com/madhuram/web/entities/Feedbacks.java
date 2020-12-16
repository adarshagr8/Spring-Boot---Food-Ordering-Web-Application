package com.madhuram.web.entities;

public class Feedbacks {
	private Integer FeedbackID;
	private java.time.LocalDateTime RecordedTime;
	private String Subject;
	private String FeedbackMessage;
	private Integer UserID;
	private Integer Status;
	
	public Integer getFeedbackID() {
		return FeedbackID;
	}
	public void setFeedbackID(Integer feedbackID) {
		FeedbackID = feedbackID;
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
	public String getFeedbackMessage() {
		return FeedbackMessage;
	}
	public void setFeedbackMessage(String feedbackMessage) {
		FeedbackMessage = feedbackMessage;
	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	
	
}	
