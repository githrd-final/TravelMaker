package com.project1.myTour;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyTourController {
	
	@Autowired
	MyTourService service;
	
	@RequestMapping("/myTour/myTourSelect")
	public ModelAndView myTourSelect(MyTourPageVo pVo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		pVo.setEmail((String)session.getAttribute("email"));
		List<MyTourVo> list = service.select(pVo);
		pVo = service.getpVo();
		mv.addObject("list", list);
		mv.addObject("pVo", pVo);
		System.out.println("삭제후 실행 완료");
		mv.setViewName("myTour/myTourSelect");
		return mv;
	} 
	
	@RequestMapping("/myTour/myTourInsert")
	public ModelAndView myTourInsert(MyTourVo vo, MyTourPageVo pVo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println(vo);
		pVo = new MyTourPageVo();
		pVo.setEmail((String)session.getAttribute("email"));
		vo = service.insertView(vo.getPurchaseSerial(), pVo.email);
		List<MyTourReviewVo> list = service.getList();
		int datePlan = Integer.parseInt(service.getDatePlan());
		String nickName = service.getNickName();

		mv.addObject("vo", vo);
		mv.addObject("list", list);
		mv.addObject("datePlan", datePlan);
		mv.addObject("nickName", nickName);
		System.out.print("구매고유번호 : "+ vo.getPurchaseSerial());
		
		mv.setViewName("myTour/reviewInsert");
		System.out.println("실행 OK");
		return mv;
	}
	
}
