package com.project1.planner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.project1.mybatis.PlanBucketMapper;

@Service
@Transactional
public class PlanBucketService {
	@Autowired
	PlatformTransactionManager manager;
	TransactionStatus status;
	Object savePoint;

	@Autowired	//동일한 클래스명을 가져옴.
	PlanBucketMapper pbmapper;
	//planmapper 추가하기!
	

	public List<BucketVo> bucketselect(String purchaseSerial){
		List<BucketVo> list = pbmapper.bucketSelect(purchaseSerial);
		return list;
	}
	public List<BucketVo> bucketDetailSelect(BucketVo bVo){
		List<BucketVo> list = pbmapper.bucketDetailSelect(bVo);
		return list;
	}
	public void bucketToPlanInsert(BucketVo bVo){
		int cnt = pbmapper.bucketToPlanInsert(bVo);
		if(cnt>0) {
			manager.commit(status);
		}else {
			status.rollbackToSavepoint(savePoint);
		}
	}
}
