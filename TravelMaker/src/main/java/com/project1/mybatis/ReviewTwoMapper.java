package com.project1.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project1.review.ReviewVo;

@Repository
@Mapper
public interface ReviewTwoMapper {
	public int insert(ReviewVo vo);
	public void myReviewUpdate(String purchaseSerial);
}
