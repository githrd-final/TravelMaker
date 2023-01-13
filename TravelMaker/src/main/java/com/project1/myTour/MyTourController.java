package com.project1.myTour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyTourController {
	
	@Autowired
	MyTourService service;
	
	@RequestMapping("/myTour/myTourSelect")
	public ModelAndView myTourSelect(MyTourPageVo pVo) {
		ModelAndView mv = new ModelAndView();
		List<MyTourVo> list = service.select(pVo);
		pVo = service.getpVo();
		
		mv.addObject("list", list);
		mv.addObject("pVo", pVo);
		mv.setViewName("myTour/myTourSelect");
		return mv;
	} 
	
	@RequestMapping("/myTour/myTourInsert")
	public ModelAndView myTourInsert(MyTourVo vo) {
		ModelAndView mv = new ModelAndView();
		System.out.println(vo);
		vo = service.insertView(vo.getPurchaseSerial());
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
