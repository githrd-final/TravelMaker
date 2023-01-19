package com.project1.member;

import com.project1.mybatis.MemberMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@NoArgsConstructor
public class MemberService{

    @Autowired
    PlatformTransactionManager transactionManager;
    TransactionStatus status;

    @Autowired
    MemberMapper memberMapper;

    Object savePoint;
    public String naverCheck(MemberDto memberDto) {
        String result = "notRegistered";
        String email = memberDto.getEmail();
        log.info("serviceNaverCheck");
        int cnt = memberMapper.findEmail(email);
        if (cnt > 0) {
            result = "registered";
        }
        return result;
    }

    public void naverSignUp(MemberDto memberDto) {
        log.info("serviceNaverSignUp");
        memberMapper.naverSignUp(memberDto);
    }
    
    public void insertMember(MemberDto memberDto) {
    	log.info("InsertMember");
        memberMapper.insertMember(memberDto);
    }
    
}