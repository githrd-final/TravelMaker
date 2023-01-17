package com.project1.myTour;

public class MyTourTicketVo {
	String ticketSerial;
	String ticketStartPoint,ticketEndPoint;
	String ticketDate;
	String ticketStartTime,ticketEndTime;
	String ticketSeat;
	String region;
	String purchaseSerial;	//구매고유번호
	boolean myReview;		//리뷰 작성 여부
	int reviewSerial;		//리뷰번호
	
	
	public boolean isMyReview() {
		return myReview;
	}
	public void setMyReview(boolean myReview) {
		this.myReview = myReview;
	}
	public int getReviewSerial() {
		return reviewSerial;
	}
	public void setReviewSerial(int reviewSerial) {
		this.reviewSerial = reviewSerial;
	}
	public String getPurchaseSerial() {
		return purchaseSerial;
	}
	public void setPurchaseSerial(String purchaseSerial) {
		this.purchaseSerial = purchaseSerial;
	}
	public String getTicketSerial() {
		return ticketSerial;
	}
	public void setTicketSerial(String ticketSerial) {
		this.ticketSerial = ticketSerial;
	}
	public String getTicketStartPoint() {
		return ticketStartPoint;
	}
	public void setTicketStartPoint(String ticketStartPoint) {
		this.ticketStartPoint = ticketStartPoint;
	}
	public String getTicketEndPoint() {
		return ticketEndPoint;
	}
	public void setTicketEndPoint(String ticketEndPoint) {
		this.ticketEndPoint = ticketEndPoint;
	}
	public String getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}
	public String getTicketStartTime() {
		return ticketStartTime;
	}
	public void setTicketStartTime(String ticketStartTime) {
		this.ticketStartTime = ticketStartTime;
	}
	public String getTicketEndTime() {
		return ticketEndTime;
	}
	public void setTicketEndTime(String ticketEndTime) {
		this.ticketEndTime = ticketEndTime;
	}
	public String getTicketSeat() {
		return ticketSeat;
	}
	public void setTicketSeat(String ticketSeat) {
		this.ticketSeat = ticketSeat;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
