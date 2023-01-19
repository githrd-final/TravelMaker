package com.project1.member;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.servlet.view.RedirectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class MemberController {

    @Resource(name = "memberService")
    MemberService memberService;


    @RequestMapping("/member/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/login");
        return mv;
    }

    @RequestMapping("/member/signUp")
    public ModelAndView signUp(HttpSession session) {
        log.info("signUp");
        System.out.println("signup : "+session.getAttribute("email"));
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

        session.setAttribute("email", email);
           
        
        return result;
    }

    @RequestMapping("/member/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping("/member/callCallBack")
    public ModelAndView callCallBack() {
        ModelAndView mv = new ModelAndView();
        log.info("callCallBack");
        mv.setViewName("member/callBack");
        return mv;
    }

    @RequestMapping("/{result}")
    public ModelAndView goSignUp(@PathVariable("result") String result) {
        ModelAndView mv = new ModelAndView();
        
        mv.addObject("result", result);
        System.out.println(result);
        log.info("goSignUp");
        mv.setViewName("member/signUp");
        return mv;
    }
    
    @RequestMapping("/member/UserAdd")
    public ModelAndView UserAdd(MemberDto dto, HttpSession session) {
        log.info("UserAdd");
        ModelAndView mv = new ModelAndView();
        String email = (String)session.getAttribute("email");
        
    	dto.setEmail(email);
    	memberService.insertMember(dto);
    	
        mv.setViewName("/index");
        return mv;
    }
}