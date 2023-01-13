package com.project1.review;

import java.time.LocalDate;


public class ReviewVo {
	int reviewSerial; //후기번호
	String reviewTitle;	//제목
	String nickName;	//닉네임
	Double reviewStar;	//별점
	String region;		//전국 or 도
	String city;		//상세지역명
	String text;		//작성글
	String postingDate;	//작성날짜
	String period;		//여행일수
	int view;			//조회수
	int thumbsUp;		//좋아요수
	String purchaseSerial;	//구매고유번호
	String sysPhoto;
	

	public String getSysPhoto() {
		return sysPhoto;
	}

	public void setSysPhoto(String sysPhoto) {
		this.sysPhoto = sysPhoto;
	}

	public int getReviewSerial() {
		return reviewSerial;
	}

	public void setReviewSerial(int reviewSerial) {
		this.reviewSerial = reviewSerial;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTile) {
		this.reviewTitle = reviewTile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Double getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(Double reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getThumbsUp() {
		return thumbsUp;
	}

	public void setThumbsUp(int thumbsUp) {
		this.thumbsUp = thumbsUp;
	}

	public String getPurchaseSerial() {
		return purchaseSerial;
	}

	public void setPurchaseSerial(String purchaseSerial) {
		this.purchaseSerial = purchaseSerial;
	}
	
	/*
	 * public static void main(String[] args) { 
	 * ReviewVo rv = new ReviewVo();
	 * System.out.println("작성날짜" + rv.postingDate); }
	 */
}
