package com.project1.plan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ListCotroller {
	@RequestMapping("/plan/recommendListMain")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("plan/recommendListMain");
		return mv;
	}
}
