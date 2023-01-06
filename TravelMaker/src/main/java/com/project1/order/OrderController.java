package com.project1.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/order/regionSelect")
    public ModelAndView regionSelect() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("order/regionSelect");
        return mv;
    }

}