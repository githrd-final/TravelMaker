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

    public void newSignUp(MemberDto memberDto) {
        log.info("serviceNewSignUp");
        memberMapper.newSignUp(memberDto);
    }

    public MemberDto findMember(String email) {
        log.info("serviceFindMember");
        MemberDto memberDto = memberMapper.findMember(email);
        return memberDto;
    }

    public void memberUpdate(MemberDto memberDto) {
        log.info("serviceMemberUpdate");
        memberMapper.memberUpdate(memberDto);
    }
}