package com.project1.mybatis;

import com.project1.member.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {

    public int findEmail(String email);

    public void newSignUp(MemberDto memberDto);

    public MemberDto findMember(String email);

    public void memberUpdate(MemberDto memberDto);
}