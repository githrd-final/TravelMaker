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
	List<ReviewPlanVo> rpList = null;;
	String datePlan;
	ReviewVo2 rVo;
	
	@Autowired
	PlatformTransactionManager manager;
	TransactionStatus status;
	Object savePoint;
	
	@Autowired
	ReviewMapper mapper;
	
	public List<ReviewVo2> select(ReviewPageVo pVo){
		int totSize = mapper.totList(pVo);
		pVo.setTotSize(totSize);
		this.pVo = pVo;
		System.out.println("service order =" + pVo.order);
		System.out.println("service totSize =" + totSize);
		List<ReviewVo2> list = mapper.select(pVo);
		
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
	public ReviewVo2 view(int reviewSerial, String purchaseSerial, String up) {
		ReviewVo2 rVo = null;
		System.out.println("리뷰시리얼 " + reviewSerial);
		if(up != null && up.equals("up")) {
			mapper.viewUp(reviewSerial);
		}
		rVo = mapper.view(reviewSerial);
		System.out.println("servicerVo :" + rVo);
		rpList = mapper.reviewPlan(purchaseSerial);
		datePlan = mapper.datePlan(purchaseSerial);
		
		return rVo;
	}
	
	public boolean chkUserLike(String userEmail, int reviewSerial) {
		boolean chkUserLike = false;
		int cnt = mapper.chkUserLike(userEmail, reviewSerial);
		if (cnt !=0) chkUserLike = true;
		
		return chkUserLike;
	}
	
	public ReviewVo2 reviewModifyView(int reviewSerial, String purchaseSerial) {
		ReviewVo2 rVo = mapper.reviewModifyView(reviewSerial);
		rpList = mapper.reviewPlan(purchaseSerial);
		datePlan = mapper.datePlan(purchaseSerial);
		
		return rVo;
	}
	
	public boolean modify(ReviewVo2 rVo){
		boolean b = false;
		status = manager.getTransaction(new DefaultTransactionDefinition());
		savePoint = status.createSavepoint();
		System.out.println("rVo text : "+rVo.getText());
		System.out.println("rVo text : "+rVo.getReviewStar());
		System.out.println("서비스 리뷰번호 : "+rVo.getReviewSerial());
		int cnt = mapper.modify(rVo);
		System.out.println("서비스 실행! cnt:"+cnt);
		if(cnt>0) {
			b = true;
			manager.commit(status);
			System.out.println("커밋완료!");
		}else {
			status.rollbackToSavepoint(savePoint);
			System.out.println("롤백됨");
		}
		return b;
	}
	
	public boolean delete(ReviewVo2 rVo) {
		status = manager.getTransaction(new DefaultTransactionDefinition());
		savePoint = status.createSavepoint();
		boolean b = false;
		
		int flag = rVo.getThumbsUp();
		System.out.println("좋아요수 : "+rVo.getThumbsUp());
		if(flag>=1) {
			int cnt1 = mapper.myReviewLikeDelete(rVo);
			int cnt2 = mapper.delete(rVo);
			if(cnt1>0 && cnt2>0) {
				b = true;
				manager.commit(status);
				System.out.println("커밋완료!");
			}else {
				status.rollbackToSavepoint(savePoint);
				System.out.println("롤백됨");
			}
		}else {
			
			int cnt = mapper.delete(rVo);
			if(cnt>0) {
				b = true;
				manager.commit(status);
				System.out.println("커밋완료!");
			}else {
				status.rollbackToSavepoint(savePoint);
				System.out.println("롤백됨");
			}
		}
		return b;
	}
	
	public void myReviewUpdate(String purchaseSerial) {
		mapper.myReviewUpdate(purchaseSerial);
	}
	
	public List<ReviewPlanVo> getRpList() {
		return rpList;
	}
	public String getDatePlan() {
		return datePlan;
	}
	
	
	public boolean thumbsUp(int reviewSerial, String userEmail, String purchaseSerial) {
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
				rpList = mapper.reviewPlan(purchaseSerial);
				datePlan = mapper.datePlan(purchaseSerial);
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
	public ReviewVo2 getrVo() {
		return rVo;
	}
	public UserVo userDetailView(String nickName) {
			UserVo uVo = null;
			uVo = mapper.userDetailView(nickName);
			System.out.println(uVo);
		return uVo;
	}
	
	public List<ReviewVo2> selectUserReview(ReviewVo2 rVo){
		List<ReviewVo2> list = mapper.selectUserReview(rVo.nickName);
		
		return list;
	}
	
	}
