package com.project1.companyInfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CompanyInfoController {
	@RequestMapping("/companyInfo/companyInfoView")
	public ModelAndView companyInfoView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("companyInfo/companyInfoView");
		return mv;
	}
}
