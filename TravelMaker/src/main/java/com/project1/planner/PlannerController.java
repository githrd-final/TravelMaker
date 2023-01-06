package com.project1.planner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PlannerController {
	
	@RequestMapping("/planner/planner")
	public ModelAndView planner() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("planner/planner");
		return mv;
	}
	
	@RequestMapping("/planner/planBucketList")
	public ModelAndView planBucketList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("planner/planBucketList");
		return mv;
	}
	
	@RequestMapping("/planner/planList")
	public ModelAndView planList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("planner/planList");
		return mv;
	}
	
}