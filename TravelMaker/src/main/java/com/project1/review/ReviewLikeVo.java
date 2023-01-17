package com.project1.review;

public class ReviewLikeVo {
	String userEmail;
	int reviewSerial;
	boolean likeChk;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getReviewSerial() {
		return reviewSerial;
	}
	public void setReviewSerial(int reviewSerial) {
		this.reviewSerial = reviewSerial;
	}
	public boolean isLikeChk() {
		return likeChk;
	}
	public void setLikeChk(boolean likeChk) {
		this.likeChk = likeChk;
	}
}
