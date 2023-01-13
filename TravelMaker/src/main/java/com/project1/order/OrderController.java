package com.project1.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value="/order/regionSelect", method = RequestMethod.GET)
    public ModelAndView regionSelect(HttpServletRequest request, HttpServletResponse response, OrderDto orderDto) throws Exception {
        log.info("regionSelect");
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        orderDto.setEmail(email);
        mv.setViewName("order/regionSelect");
        return mv;
    }

    @RequestMapping(value="/order/regionSelectB", method = RequestMethod.GET)
    public ModelAndView regionSelectB(HttpServletRequest request, OrderDto orderDto) throws Exception {
        log.info("regionSelect");
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();

        String email = session.getAttribute("email").toString();
        orderDto.setEmail(email);
        log.info(orderDto.getEmail());
        log.info(orderDto.getPeople());
        log.info(orderDto.getStartDate());
        log.info(orderDto.getEndDate());
        log.info(orderDto.getStartDateTime());
        log.info(orderDto.getEndDateTime());
        request.setAttribute("orderDto", orderDto);
        log.info(request.getParameter("people"));
        mv.addObject("orderDto", orderDto);
        mv.setViewName("order/regionSelect");
        return mv;
    }

    @RequestMapping("/order/purchaseCheck")
    public ModelAndView purchaseCheck(HttpServletRequest request, OrderDto orderDto) throws Exception {
        log.info("purchaseCheck");
        ModelAndView mv = new ModelAndView();
        orderDto.setRegion(request.getParameter("region"));
        mv.addObject("orderDto", orderDto);
        mv.setViewName("order/purchaseCheck");
        return mv;
    }

    @RequestMapping("/order/purchasedTicket")
    public ModelAndView purchasedTicket(HttpServletRequest request, HttpSession session, OrderDto orderDto) {
        ModelAndView mv = new ModelAndView();
        log.info("purchasedTicket");
        String purchaseNumber = orderService.purchaseTicket(orderDto);
        mv.setViewName("order/purchasedTicket");
        return mv;
    }
}