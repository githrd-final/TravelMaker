package com.project1.review;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.project1.mybatis.ReviewMapper;

@Service
@Transactional
public class ReviewService {
	ReviewPageVo pVo;
	ReviewVo rVo;
	
	@Autowired
	PlatformTransactionManager manager;
	TransactionStatus status;
	Object savePoint;
	
	@Autowired
	ReviewMapper mapper;
	
	public List<ReviewVo> select(ReviewPageVo pVo){
		int totSize = mapper.totList(pVo);
		pVo.setTotSize(totSize);
		this.pVo = pVo;
		System.out.println("service order =" + pVo.order);
		System.out.println("service totSize =" + totSize);
		List<ReviewVo> list = mapper.select(pVo);
		
		System.out.println("service list : "+ list.toString());
		return list;
	}
	public List<String> selectRegion(String region){
		List<String> regionCity = mapper.selectRegion(region);
		
		return regionCity;
	}
	public ReviewPageVo getpVo() {
		return pVo;
	}
	public ReviewVo view(int reviewSerial, String up) {
		ReviewVo rVo = null;
		System.out.println("리뷰시리얼 " + reviewSerial);
		if(up != null && up.equals("up")) {
			mapper.viewUp(reviewSerial);
		}
		rVo = mapper.view(reviewSerial);
		System.out.println("servicerVo :" + rVo);
		
		return rVo;
	}
	
	public boolean chkUserLike(String userEmail, int reviewSerial) {
		boolean chkUserLike = false;
		int cnt = mapper.chkUserLike(userEmail, reviewSerial);
		if (cnt !=0) chkUserLike = true;
		
		return chkUserLike;
	}
	
	public boolean thumbsUp(int reviewSerial, String userEmail) {
		status = manager.getTransaction(new DefaultTransactionDefinition());
		savePoint = status.createSavepoint();
		
		boolean flag = true;
		int cnt = mapper.thumbsUp(reviewSerial, userEmail);
		if(cnt<1) {
			flag = false;
			status.rollbackToSavepoint(savePoint);
		}else {
			int cnt2 = mapper.thumbsUpR(reviewSerial);
			if(cnt2<1) {
				flag = false;
				status.rollbackToSavepoint(savePoint);
			}else {
				manager.commit(status);
				rVo = mapper.view(reviewSerial);
				pVo.setChkUserLike(true);
			}
		}
		
		return flag;
	}
	public boolean thumbsDown(int reviewSerial, String userEmail) {
		status = manager.getTransaction(new DefaultTransactionDefinition());
		savePoint = status.createSavepoint();
		System.out.println("userEmail/ service / thumbsDown : " + userEmail);
		boolean flag = true;
		int cnt = mapper.thumbsDown(reviewSerial, userEmail);
		if(cnt<1) {
			flag = false;
			status.rollbackToSavepoint(savePoint);
		}else {
			int cnt2 = mapper.thumbsDownR(reviewSerial);
			if(cnt2<1) {
				flag = false;
				status.rollbackToSavepoint(savePoint);
			}else {
				manager.commit(status);
				rVo = mapper.view(reviewSerial);
				pVo.setChkUserLike(false);
			}
		}
		return flag;
	}
	public ReviewVo getrVo() {
		return rVo;
	}
	
	
	}
