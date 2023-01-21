package com.project1.myInfo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project1.review.UserVo;

@RestController
public class MyInfoController {
	@Autowired 
	MyInfoService service;
	@RequestMapping("/myInfo/myInfoView")
	public ModelAndView view(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String email = (String)session.getAttribute("email");
		UserVo uVo = service.view(email);
		mv.addObject("uVo", uVo);
		mv.setViewName("myInfo/myInfoView");
		return mv; 
	}
	
	/*@RequestMapping("/myInfo/myInfoModify")
	public ModelAndView Modify() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myInfo/myInfo");
		return mv;
	}*/
}