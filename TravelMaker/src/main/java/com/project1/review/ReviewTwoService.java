package com.project1.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.project1.mybatis.ReviewTwoMapper;

@Service
@Transactional
public class ReviewTwoService {
	ReviewVo rVo;
	
	@Autowired
	ReviewTwoMapper mapper;
	
	@Autowired
	PlatformTransactionManager manager;
	TransactionStatus status;

	public boolean insert(ReviewVo vo){
		boolean b = false;
		status = manager.getTransaction(new DefaultTransactionDefinition());
		Object savePoint = status.createSavepoint();
		
		int cnt = mapper.insert(vo);
		System.out.println("서비스 실행! cnt:"+cnt);
		if(cnt>0) {
			b = true;
			manager.commit(status);
			rVo = mapper.myReviewView(vo.getPurchaseSerial());
		}else {
			status.rollbackToSavepoint(savePoint);
		}
		return b;
	}
	
	public void myReviewUpdate(String purchaseSerial) {
		mapper.myReviewUpdate(purchaseSerial);
	}

	public ReviewVo getrVo() {
		return rVo;
	}
	
}
