package com.project1.myTour;

public class MyTourVo {
	String region;			//전국 or 도(지역카테고리)
	String city;			//목적지
	String startDate;		//가는날
	String endDate;			//오는날
	int people;				//인원
	String purchaseSerial;	//구매고유번호
	
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getPurchaseSerial() {
		return purchaseSerial;
	}
	public void setPurchaseSerial(String purchaseSerial) {
		this.purchaseSerial = purchaseSerial;
	}
	
}
