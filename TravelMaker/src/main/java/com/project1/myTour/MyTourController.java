package com.project1.myTour;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyTourController {
	
	@RequestMapping("/myTour/myTourSelect")
	public ModelAndView myTourSelect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myTour/myTourSelect");
		return mv;
	} 
	
	@RequestMapping("/myTour/reviewInsert")
	public ModelAndView reviewInsert() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myTour/reviewInsert");
		System.out.println("실행 OK");
		return mv;
	}
	
}
