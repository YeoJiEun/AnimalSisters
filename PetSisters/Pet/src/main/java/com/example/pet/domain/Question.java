package com.example.pet.domain;
import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Question implements Serializable {
	private int questionNum;
	private int mNum;
	private String questionTitle;
	private String questionContent;
	private Date questionDate;
	private String mType;
	private int questionHits;
	private String mNickname;
	
	public Question() {  }

	public Question(int questionNum, String questionTitle, Date questionDate, int questionHits, String mNickname) {
		super();
		this.questionNum = questionNum;
		this.questionTitle = questionTitle;
		this.questionDate = questionDate;
		this.questionHits = questionHits;
		this.mNickname = mNickname;
	}
	
	public Question(int questionNum, int mNum, String questionTitle, String questionContent, Date questionDate,
			String mType, int questionHits) {
		this.questionNum = questionNum;
		this.mNum = mNum;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionDate = questionDate;
		this.mType = mType;
		this.questionHits = questionHits;
	}

	public Question(int questionNum, int mNum, String questionTitle, String questionContent, String mType) {
		this.questionNum = questionNum;
		this.mNum = mNum;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.mType = mType;
	}

	public int getQuestionNum() { return questionNum; }
	public void setQuestionNum(int questionNum) { this.questionNum = questionNum; }

	public int getmNum() { return mNum; }
	public void setmNum(int mNum) { this.mNum = mNum; }

	public String getQuestionTitle() { return questionTitle; }
	public void setQuestionTitle(String questionTitle) { this.questionTitle = questionTitle; }

	public String getQuestionContent() { return questionContent; }
	public void setQuestionContent(String questionContent) { this.questionContent = questionContent; }

	public Date getQuestionDate() { return questionDate; }
	public void setQuestionDate(Date questionDate) { this.questionDate = questionDate; }

	public String getmType() { return mType; }
	public void setmType(String mType) { this.mType = mType; }

	public int getQuestionHits() { return questionHits; }
	public void setQuestionHits(int questionHits) { this.questionHits = questionHits; }
	
	public String getmNickname() { return mNickname; }
	public void setmNickname(String mNickname) { this.mNickname = mNickname; }

	@Override
	public String toString() {
		return "Question [questionNum=" + questionNum + ", mNum=" + mNum + ", questionTitle=" + questionTitle
				+ ", questionContent=" + questionContent + ", questionDate=" + questionDate + ", mType=" + mType
				+ ", questionHits=" + questionHits + "]";
	}
}
