	package com.madhuram.web.entities;

public class FAQ {
	private Integer QuestionID;
	private String Question;
	private String Answer;
	public Integer getQuestionID() {
		return QuestionID;
	}
	public void setQuestionID(Integer questionID) {
		QuestionID = questionID;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	@Override
	public String toString() {
		return "FAQ [QuestionID=" + QuestionID + ", Question=" + Question + ", Answer=" + Answer + "]";
	}
	
	
}
