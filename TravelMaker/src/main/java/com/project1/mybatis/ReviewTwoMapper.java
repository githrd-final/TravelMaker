package com.project1.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project1.review.ReviewVo;
import com.project1.review.UserVo;

@Repository
@Mapper
public interface ReviewTwoMapper {
	public int insert(ReviewVo vo);
	public ReviewVo myReviewView(String purchaseSerial);
	public void myReviewUpdate(String purchaseSerial);
	public UserVo userDetailView(String nickName);
}