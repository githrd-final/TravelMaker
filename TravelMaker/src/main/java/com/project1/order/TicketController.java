package com.project1.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class TicketController {
	

	//@RequestMapping("/order/purchasedTicket")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("order/purchasedTicket");
		return mv;
	}
}