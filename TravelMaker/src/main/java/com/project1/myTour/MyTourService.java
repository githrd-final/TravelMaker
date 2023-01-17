package com.project1.myTour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project1.mybatis.MyTourMapper;

@Service
@Transactional
public class MyTourService {
	MyTourPageVo pVo;
	List<MyTourReviewVo> list=null;
	String datePlan;
	String nickName;
	

	@Autowired
	MyTourMapper mapper;
	
	public List<MyTourVo> select(MyTourPageVo pVo){
		int totSize = mapper.totList(pVo);
		pVo.setTotSize(totSize);
		System.out.println("totSize : " + pVo.totSize);
		this.pVo = pVo;
		System.out.println("totPage : "+ pVo.totPage);
		List<MyTourVo> list = mapper.select(pVo);
		
		return list;
	}
	
	public List<MyTourTicketVo> TicketView(String purchaseSerial){
		System.out.println("서비스 구매고유번호: "+ purchaseSerial);
		List<MyTourTicketVo> list = mapper.TicketView(purchaseSerial);
		return list;
	}
	
	public MyTourVo insertView(String purchaseSerial){
		System.out.println("서비스 구매고유번호: "+ purchaseSerial);
		MyTourVo vo = mapper.insertView(purchaseSerial);
		System.out.println("인서트뷰"+vo.getPurchaseSerial());
		list = mapper.myTourReview(purchaseSerial);
		System.out.println(list);
		datePlan = mapper.datePlan(purchaseSerial);
		System.out.println(datePlan);
		nickName = mapper.nickName(purchaseSerial);
		System.out.println(nickName);
		
		return vo;
	}

	public MyTourPageVo getpVo() {
		return pVo;
	}

	public List<MyTourReviewVo> getList() {
		return list;
	}

	public String getDatePlan() {
		return datePlan;
	}

	public String getNickName() {
		return nickName;
	}
	
	
}
