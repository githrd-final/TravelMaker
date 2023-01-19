package com.project1.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project1.review.UserVo;

@Repository
@Mapper
public interface MyInfoMapper {
	public UserVo view(String email);
}
