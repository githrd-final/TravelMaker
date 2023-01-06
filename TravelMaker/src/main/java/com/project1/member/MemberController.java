package com.project1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/member/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/login");
        return mv;
    }

    @RequestMapping("/member/signUp")
    public ModelAndView signUp() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/signUp");
        return mv;
    }

}
