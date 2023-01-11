package com.project1.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
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
        log.info("signUp");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/signUp");
        return mv;
    }

    @RequestMapping("/member/callSignUp")
    public String callSignUp() {
        log.info("callSignUp");
        return "redirect:/member/signUp";
    }


    @RequestMapping(value="/member/callBack", method=RequestMethod.GET)
    public ModelAndView callBack(){
        log.info("callBack");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/callBack");
        return mv;
    }

    @RequestMapping(value = "/member/naverCheck", method = RequestMethod.POST)
    public @ResponseBody String naverCheck(@RequestParam("n_email") String email, @RequestParam("n_id") String id, @RequestParam("n_name") String name, HttpSession session) {

        log.info("naverCheck");
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail(email);
        memberDto.setUserComment(id);

        String result = memberService.naverCheck(memberDto);

        if(result == "registered") {
            session.setAttribute("email", email);
        }
        return result;
    }
}