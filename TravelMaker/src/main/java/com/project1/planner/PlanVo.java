package com.project1.planner;

	public class PlanVo { 
		
		int planOrder = 0; 		  // 순번
		String planDate;		  // 일차
		String planbucketSerial;  //일정예약고유변호
		String locationName;	  // 상호명
		String mapX;			  // x좌표
		String mapY;		   	  // y좌표
		String planNote = ""; 	  // 메모
		
		String purchaseSerial;
		String prePlanDate;
		String contenttypeId;
		int prePlanOrder = 0;  // 수정하기 이전의 순번
		
		public String getContenttypeId() {
			return contenttypeId;
		}
		public void setContenttypeId(String contenttypeId) {
			this.contenttypeId = contenttypeId;
		}
		public String getPlanDate() {
			return planDate;
		}
		public void setPlanDate(String planDate) {
			this.planDate = planDate;
		}
		public int getPlanOrder() {
			return planOrder;
		}
		public void setPlanOrder(int planOrder) {
			this.planOrder = planOrder;
		}
		public String getPlanbucketSerial() {
			return planbucketSerial;
		}
		public void setPlanbucketSerial(String planbucketSerial) {
			this.planbucketSerial = planbucketSerial;
		}
		public String getLocationName() {
			return locationName;
		}
		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}
		public String getMapX() {
			return mapX;
		}
		public void setMapX(String mapX) {
			this.mapX = mapX;
		}
		public String getMapY() {
			return mapY;
		}
		public void setMapY(String mapY) {
			this.mapY = mapY;
		}
		public String getPlanNote() {
			return planNote;
		}
		public void setPlanNote(String planNote) {
			this.planNote = planNote;
		}
		public String getPrePlanDate() {
			return prePlanDate;
		}
		public void setPrePlanDate(String prePlanDate) {
			this.prePlanDate = prePlanDate;
		}
		public int getPrePlanOrder() {
			return prePlanOrder;
		}
		public void setPrePlanOrder(int prePlanOrder) {
			this.prePlanOrder = prePlanOrder;
		}
		public String getPurchaseSerial() {
			return purchaseSerial;
		}
		public void setPurchaseSerial(String purchaseSerial) {
			this.purchaseSerial = purchaseSerial;
		}
		
		
		
	}	
