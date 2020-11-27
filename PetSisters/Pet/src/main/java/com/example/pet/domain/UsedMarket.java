package com.example.pet.domain;
import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class UsedMarket implements Serializable {
	private int uNum;
	private int mNum;
	private int gNum;
	private String uTitle;
	private String uContent;
	private String uUsedate;
	private Date uExpiredate;
	private int uPrice;
	private Date uDate;
	private String uCompleteTF;
	private int uHits;
	
	private String mNickname;
	private String mType;
	private String gType;
		
	public UsedMarket() {
		super();
	}

	public UsedMarket(int uNum, String uTitle) {
		this.uNum = uNum;
		this.uTitle = uTitle;
	}
	
	public UsedMarket(int uNum, String mNickname, String uTitle, String uContent, Date uDate, int uHits) {
		this.uNum = uNum;
		this.mNickname = mNickname;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uDate = uDate;
		this.uHits = uHits;
	}
	
	public UsedMarket(int uNum, int mNum, String uTitle, String uContent, String uUsedate,
			Date uExpiredate, int uPrice, Date uDate, String uCompleteTF, int uHits, 
			String mNickname, String mType, String gType) {
		this.uNum = uNum;
		this.mNum = mNum;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uUsedate = uUsedate;
		this.uExpiredate = uExpiredate;
		this.uPrice = uPrice;
		this.uDate = uDate;
		this.uCompleteTF = uCompleteTF;
		this.uHits = uHits;
		this.mNickname = mNickname;
		this.mType = mType;
		this.gType = gType;
	}
	
	public UsedMarket(int uNum, int mNum, int gNum, String uTitle, String uContent, String uUsedate, Date uExpiredate,
			int uPrice, Date uDate, String uCompleteTF, int uHits, String mNickname, String mType, String gType) {
		super();
		this.uNum = uNum;
		this.mNum = mNum;
		this.gNum = gNum;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uUsedate = uUsedate;
		this.uExpiredate = uExpiredate;
		this.uPrice = uPrice;
		this.uDate = uDate;
		this.uCompleteTF = uCompleteTF;
		this.uHits = uHits;
		this.mNickname = mNickname;
		this.mType = mType;
		this.gType = gType;
	}

	public UsedMarket(int uNum, int mNum, int gNum, String uTitle, String uContent, String uUsedate, Date uExpiredate, int uPrice) {
		this.uNum = uNum;
		this.mNum = mNum;
		this.gNum = gNum;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uUsedate = uUsedate;
		this.uExpiredate = uExpiredate;
		this.uPrice = uPrice;
	}
	
	public UsedMarket(int uNum, int mNum, int gNum, String uTitle, String uContent, String uUsedate, int uPrice) {
		this.uNum = uNum;
		this.mNum = mNum;
		this.gNum = gNum;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uUsedate = uUsedate;
		this.uPrice = uPrice;
	}
	
	public UsedMarket(int uNum, int gNum, String uTitle, String uContent, String uUsedate, Date uExpiredate, int uPrice) {
		this.uNum = uNum;
		this.gNum = gNum;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uUsedate = uUsedate;
		this.uExpiredate = uExpiredate;
		this.uPrice = uPrice;
	}
	
	public UsedMarket(int uNum, int gNum, String uTitle, String uContent, String uUsedate, int uPrice) {
		this.uNum = uNum;
		this.gNum = gNum;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uUsedate = uUsedate;
		this.uPrice = uPrice;
	}
	
	public UsedMarket(int uNum, int gNum, String uTitle, String uContent, Date uExpiredate, int uPrice) {
		this.uNum = uNum;
		this.gNum = gNum;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uExpiredate = uExpiredate;
		this.uPrice = uPrice;
	}
	
	public UsedMarket(int uNum, int gNum, String uTitle, String uContent, int uPrice) {
		this.uNum = uNum;
		this.gNum = gNum;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.uPrice = uPrice;
	}

	public int getuNum() { return uNum; }
	public void setuNum(int uNum) { this.uNum = uNum; }

	public int getmNum() { return mNum; }
	public void setmNum(int mNum) { this.mNum = mNum; }

	public int getgNum() { return gNum; }
	public void setgNum(int gNum) { this.gNum = gNum; }

	public String getuTitle() { return uTitle; }
	public void setuTitle(String uTitle) { this.uTitle = uTitle; }

	public String getuContent() { return uContent; }
	public void setuContent(String uContent) { this.uContent = uContent; }

	public String getuUsedate() { return uUsedate; }
	public void setuUsedate(String uUsedate) { this.uUsedate = uUsedate; }

	public Date getuExpiredate() { return uExpiredate; }
	public void setuExpiredate(Date uExpiredate) { this.uExpiredate = uExpiredate; }

	public int getuPrice() { return uPrice; }
	public void setuPrice(int uPrice) { this.uPrice = uPrice; }

	public Date getuDate() { return uDate; }
	public void setuDate(Date uDate) { this.uDate = uDate; }

	public String getuCompleteTF() { return uCompleteTF; }
	public void setuCompleteTF(String uCompleteTF) { this.uCompleteTF = uCompleteTF; }
	
	public int getuHits() { return uHits; }
	public void setuHits(int uHits) { this.uHits = uHits; }
	
	public String getmNickname() { return mNickname; }
	public void setmNickname(String mNickname) { this.mNickname = mNickname; }
	
	public String getmType() { return mType; }
	public void setmType(String mType) { this.mType = mType; }

	public String getgType() { return gType; }
	public void setgType(String gType) { this.gType = gType; }

	@Override
	public String toString() {
		return "UsedMarket [uNum=" + uNum + ", mNum=" + mNum + ", gNum=" + gNum + ", uTitle=" + uTitle + ", uContent="
				+ uContent + ", uUsedate=" + uUsedate + ", uExpiredate=" + uExpiredate + ", uPrice=" + uPrice
				+ ", uDate=" + uDate + ", uCompleteTF=" + uCompleteTF + ", uHits=" + uHits + ", mNickname=" + mNickname
				+ ", mType=" + mType + ", gType=" + gType + "]";
	}
}
