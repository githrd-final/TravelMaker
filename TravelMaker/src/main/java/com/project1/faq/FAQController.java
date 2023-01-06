package com.project1.faq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FAQController {
	@RequestMapping("/faq/faqView")
	public ModelAndView faqView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("faq/faqView");
		return mv;
	}
}
