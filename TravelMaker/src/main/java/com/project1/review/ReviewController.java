package com.project1.review;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project1.myTour.MyTourPageVo;

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
		session.setAttribute("email", "happilyah@naver.com");
		String userEmail = (String)session.getAttribute("email");
		pVo.setChkUserLike(service.chkUserLike(userEmail, rVo.getReviewSerial()));
		System.out.println("rs : " +rVo.getReviewSerial());
		System.out.println("컨트롤 구고번호1: "+ rVo.getPurchaseSerial());
		rVo = service.view(rVo.getReviewSerial(), "up");
		
		System.out.println("컨트롤 구고번호2: "+ rVo.getPurchaseSerial());
		mv.addObject("rVo", rVo);
		mv.addObject("pVo", pVo);
		System.out.println("rVo---"+rVo);
		System.out.println("city"+rVo.city);
		mv.setViewName("review/reviewView");
		return mv;
	}
	
	@RequestMapping("/review/reviewRegion")
	public List<String> selectRegion(String region){
		List<String> regionCity = service.selectRegion(region);
		
		return regionCity;
	}
	
	@RequestMapping("/review/reviewModifyView")
	public ModelAndView reviewModifyView(ReviewVo rVo) {
		ModelAndView mv = new ModelAndView();
		rVo = service.reviewModifyView(rVo.getReviewSerial(), rVo.getPurchaseSerial());
		System.out.println("컨트롤러 구고번호: "+rVo.getPurchaseSerial());
		List<ReviewPlanVo> rpList = service.getRpList();
		int datePlan = Integer.parseInt(service.getDatePlan());
		
		mv.addObject("rVo", rVo);
		mv.addObject("rpList", rpList);
		mv.addObject("datePlan", datePlan);
		mv.setViewName("review/reviewModify");
		return mv;
	}
	
	@RequestMapping("/review/reviewModify")
	public ModelAndView reviewModify(ReviewVo rVo, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		ReviewPageVo pVo = new ReviewPageVo();
		ModelAndView mv = new ModelAndView();
		
		System.out.println("컨트롤러 실행! 리뷰번호:"+rVo.getReviewSerial());
		boolean b = service.modify(rVo);
		System.out.println("컨트롤러 실행! 구고번호:"+rVo.getPurchaseSerial());
		try {
			PrintWriter out = resp.getWriter();
			if(!b) {
				out.print("<script>");
				out.print("   alert('저장 중 오류 발생')");
				out.print("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mv.addObject("rVo", rVo);
		mv.setViewName("/review/reviewView");
		return mv;
		
	}
	
	@RequestMapping("/review/reviewDelete")
	public MyTourPageVo reviewDelete(ReviewVo rVo, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		ModelAndView mv = new ModelAndView();
		MyTourPageVo pVo = new MyTourPageVo();
		boolean b = service.delete(rVo);
		service.myReviewUpdate(rVo.getPurchaseSerial());
		System.out.println("삭제 컨트롤러 실행! 구고번호:"+rVo.getPurchaseSerial());
		
		return pVo;
		
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
