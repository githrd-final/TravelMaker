package com.project1.review;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReviewController {
	@RequestMapping("/review/reviewSelect")
	public ModelAndView reviewSelect() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/reviewSelect");
		return mv;
	}
	
	@RequestMapping("/review/reviewView")
	public ModelAndView reviewView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/reviewView");
		return mv;
	}
	
	@RequestMapping("/review/reviewModify")
	public ModelAndView reviewModify() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/reviewModify");
		return mv;
	}
}
