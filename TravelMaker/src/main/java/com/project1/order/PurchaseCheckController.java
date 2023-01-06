package com.project1.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project1.order.OrderService;


@RestController
public class PurchaseCheckController {
	
	@Autowired
	OrderService service;

	@RequestMapping("/order/purchaseCheck")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("order/purchaseCheck");
		return mv;
	}
}
