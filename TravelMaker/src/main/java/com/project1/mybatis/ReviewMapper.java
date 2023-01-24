package com.project1.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project1.review.RegionCityVo;
import com.project1.review.ReviewPageVo;
import com.project1.review.ReviewPlanVo;

import com.project1.review.ReviewVo;
import com.project1.review.ReviewVo2;
import com.project1.review.UserVo;

@Repository
@Mapper
public interface ReviewMapper {
	//select
	public int totList(ReviewPageVo pVo);
	public List<ReviewVo2> select(ReviewPageVo pVo);
	public List<String> selectRegion(String region);
	
	//view
	public void viewUp(int reviewSerial);
	public ReviewVo2 view(int reviewSerial);
	public int chkUserLike(@Param("userEmail") String userEmail, @Param("reviewSerial") int reviewSerial);

//	public int thumbsUp(ReviewVo rVo, String email);
	
	//modify view
	public ReviewVo2 reviewModifyView(int reviewSerial);
	public List<ReviewPlanVo> reviewPlan(String purchaseSerial);
	public String datePlan(String purchaseSerial);

	//modify
	public int modify(ReviewVo2 rVo);
	
	//delete
	public int delete(ReviewVo2 rVo);
	public int myReviewLikeDelete(ReviewVo2 rVo);
	public void myReviewUpdate(String purchaseSerial);

	public int thumbsUp(@Param("reviewSerial") int reviewSerial, @Param("userEmail") String userEmail);
	public int thumbsDown(@Param("reviewSerial") int reviewSerial, @Param("userEmail") String userEmail);
	
	public int thumbsUpR(int reviewSerial);
	public int thumbsDownR(int reviewSerial);
	
	public UserVo userDetailView(String nickName);
	public List<ReviewVo2> selectUserReview(String nickName);
}
