package com.project1.myInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.mybatis.MyInfoMapper;
import com.project1.review.UserVo;

@Service
public class MyInfoService {

	@Autowired
	MyInfoMapper mapper;
	public UserVo view(String email) {
		UserVo uVo = mapper.view(email);
		System.out.println("myInfo 이메일 : "+email);
		
		return uVo;
	}
		
}
