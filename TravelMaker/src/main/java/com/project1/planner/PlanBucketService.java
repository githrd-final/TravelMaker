package com.project1.planner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.project1.mybatis.PlanBucketMapper;
import com.project1.mybatis.PlanMapper;

@Service
@Transactional
public class PlanBucketService {
	@Autowired
	PlatformTransactionManager manager;
	TransactionStatus status;
	Object savePoint;

	@Autowired	//동일한 클래스명을 가져옴.
	PlanBucketMapper pbmapper;
	
	
	public int TravelDay(String purchaseSerial) {
		int travelDay  = pbmapper.TravelDay(purchaseSerial);
		return travelDay;
	}

	public List<BucketVo> bucketselect(String purchaseSerial){
		List<BucketVo> list = pbmapper.bucketSelect(purchaseSerial);
		return list;
	}
	public List<BucketVo> bucketDetailSelect(BucketVo bVo){
		List<BucketVo> list = pbmapper.bucketDetailSelect(bVo);
		return list;
	}
	public String bucketToPlanInsert(BucketVo bVo){
		status = manager.getTransaction(new DefaultTransactionDefinition());
		String msg="";
		Object savePoint = status.createSavepoint();
		int count = pbmapper.InsertCountPlan(bVo.getPlanbucketSerial());
		if(count==0) {
			int cnt = pbmapper.bucketToPlanInsert(bVo);
			if(cnt>0) {
				manager.commit(status);
			}else {
				status.rollbackToSavepoint(savePoint);
			}
		}else {
			msg="이미 일정리스트에 존재하는 일정입니다.";
		}
		return msg;
	}
	
	public void planBucketDelete(BucketVo bVo) {
		status = manager.getTransaction(new DefaultTransactionDefinition());
		Object savePoint = status.createSavepoint();
		
		int cnt = pbmapper.planBucketDelete(bVo.getPlanbucketSerial());
		if(cnt>0) {
			manager.commit(status);
		}else {
			status.rollbackToSavepoint(savePoint);
		}
	}
	
	public String recommendSelect(String purchase) {
		String city = pbmapper.recommendSelect(purchase);
		return city;
	}
}
