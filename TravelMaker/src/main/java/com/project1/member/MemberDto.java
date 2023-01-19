package com.project1.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberDto {
    private String email;
    private String nickname;
    private String userComment;
    private String oriUserPhoto;
    private String sysUserPhoto;
    
    
}
