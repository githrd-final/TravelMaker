package com.project1.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project1.myTour.MyTourPageVo;
import com.project1.myTour.MyTourReviewVo;
import com.project1.myTour.MyTourTicketVo;
import com.project1.myTour.MyTourVo;


@Repository
@Mapper
public interface MyTourMapper {
	public int totList(MyTourPageVo pVo);
	public List<MyTourVo> select(MyTourPageVo pVo);
	
	public List<MyTourTicketVo> TicketView(String purchaseSerial);
	
	public MyTourVo insertView(String purchaseSerial);
	public List<MyTourReviewVo> myTourReview(String purchaseSerial);
	public String datePlan(String purchaseSerial);
	public String nickName(String purchaseSerial);
}
