package com.project1.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewService service;
	@RequestMapping("/review/reviewSelect")
	public ModelAndView reviewSelect(ReviewPageVo pVo) {
		ModelAndView mv = new ModelAndView();
		System.out.println("order : " + pVo.order);
		List<ReviewVo> list = service.select(pVo);
		pVo = service.getpVo();
		mv.addObject("list", list);
		mv.addObject("pVo", pVo);
		mv.setViewName("review/reviewSelect");
		
		System.out.println("list: " + list.toString());
		System.out.println("pVo: " + pVo);
		return mv;
	}
	
	@RequestMapping("/review/reviewView")
	public ModelAndView reviewView(ReviewVo rVo, ReviewPageVo pVo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.setAttribute("email", "abc@naver.com"); // 추후로그인 세션 있으면 지울 부분 
		String userEmail = (String)session.getAttribute("email");
		pVo.setChkUserLike(service.chkUserLike(userEmail, rVo.getReviewSerial()));
		rVo = service.view(rVo.getReviewSerial(), "up");
		
		
		mv.addObject("rVo", rVo);
		mv.addObject("pVo", pVo);
		System.out.println("rVo---"+rVo);
		System.out.println("city"+rVo.city);
		mv.setViewName("review/reviewView");
		return mv;
	}
	
	@RequestMapping("/review/reviewModify")
	public ModelAndView reviewModify() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/reviewModify");
		return mv;
	}
	@RequestMapping("/review/reviewRegion")
	public List<String> selectRegion(String region){
		List<String> regionCity = service.selectRegion(region);
		
		return regionCity;
	}
	@RequestMapping("/review/reviewThumbsUp")
	public ModelAndView thumbsUp(ReviewVo rVo, ReviewPageVo pVo, HttpSession session){
		ModelAndView mv = new ModelAndView();
		String userEmail = (String)session.getAttribute("email");
		System.out.println("chkUserLike : " + pVo.chkUserLike);
		if(!pVo.chkUserLike) {
			boolean flag = service.thumbsUp(rVo.reviewSerial, userEmail);
			if(flag) rVo.setThumbsUp(rVo.thumbsUp + 1);
		}else {
			boolean flag = service.thumbsDown(rVo.reviewSerial, userEmail);
			if(flag) rVo.setThumbsUp(rVo.thumbsUp -1 );
		}
		rVo = service.getrVo();
		pVo = service.getpVo();
		System.out.println(pVo.chkUserLike);
		mv.addObject("rVo", rVo);
		mv.addObject("pVo", pVo);
		mv.setViewName("review/reviewView");
		
		
		return mv;
	}
}
