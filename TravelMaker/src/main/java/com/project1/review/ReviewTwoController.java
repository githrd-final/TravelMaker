package com.project1.review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReviewTwoController {
	String uploadPath = "C:\\Users\\junah\\git\\TravelMaker\\TravelMaker\\src\\main\\resources\\static\\upload\\";
	
	@Autowired
	ReviewTwoService service;
	
	@RequestMapping("/review/reviewInsert")
	public ModelAndView reviewView(ReviewVo rVo, HttpServletResponse resp, HttpSession session) {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		ReviewPageVo pVo = new ReviewPageVo();
		
		ModelAndView mv = new ModelAndView();
		boolean b = service.insert(rVo);
		service.myReviewUpdate(rVo.getPurchaseSerial());
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
		rVo = service.getrVo();
		
		System.out.println("rVo.serial: " + rVo.getReviewSerial());
		System.out.println(rVo.nickName);
		
		UserVo uVo = service.userDetailView(rVo.nickName);
		System.out.println("uVo=" + uVo.toString());
		String userEmail = (String)session.getAttribute("email");
		mv.addObject("userEmail", userEmail);
		mv.addObject("uVo", uVo);
		mv.addObject("rVo", rVo);
		mv.addObject("pVo", pVo);
		mv.setViewName("review/reviewView");
		return mv;
		
	}
	
	@RequestMapping("/review/myReviewView")
	public ModelAndView myReviewView(ReviewVo rVo, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		ReviewPageVo pVo = new ReviewPageVo();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("rVo",rVo);
		mv.addObject("pVo", pVo);
		mv.setViewName("review/reviewView");
		return mv;
		
	}
}