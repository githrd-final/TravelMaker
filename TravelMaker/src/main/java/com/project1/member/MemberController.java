package com.project1.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    @RequestMapping("/member/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/login");
        return mv;
    }

    @RequestMapping("/member/signUp")
    public ModelAndView signUp() {
        logger.info("signUp");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/signUp");
        return mv;
    }

}
