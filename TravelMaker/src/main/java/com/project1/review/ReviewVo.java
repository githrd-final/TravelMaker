package com.project1.review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ReviewVo {
	String reviewSerial; //후기번호
	String reviewTile;	//제목
	String nickName;	//닉네임
	Double reviewStar;	//별점
	String region;		//전국 or 도
	String city;		//상세지역명
	long text;			//작성글
	String postingDate = LocalDate.now().toString();	//작성날짜
	String period;		//여행일수
	int view;			//조회수
	int thumbsUP;		//좋아요수
	boolean myReview;	//내게시물여부
	String purchaseSerial;	//구매고유번호
	
	List<ReviewPhotoVo> attList = new ArrayList<ReviewPhotoVo>();

	public String getReviewSerial() {
		return reviewSerial;
	}

	public void setReviewSerial(String reviewSerial) {
		this.reviewSerial = reviewSerial;
	}

	public String getReviewTile() {
		return reviewTile;
	}

	public void setReviewTile(String reviewTile) {
		this.reviewTile = reviewTile;
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

	public long getText() {
		return text;
	}

	public void setText(long text) {
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

	public int getThumbsUP() {
		return thumbsUP;
	}

	public void setThumbsUP(int thumbsUP) {
		this.thumbsUP = thumbsUP;
	}

	public boolean isMyReview() {
		return myReview;
	}

	public void setMyReview(boolean myReview) {
		this.myReview = myReview;
	}

	public List<ReviewPhotoVo> getAttList() {
		return attList;
	}

	public void setAttList(List<ReviewPhotoVo> attList) {
		this.attList = attList;
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
