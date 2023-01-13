package com.project1.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
        log.info(request.getParameter("startDate").toString());
        log.info(request.getParameter("people").toString());
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        orderDto.setEndDate(request.getParameter("endDate"));
        orderDto.setPeople(request.getParameter("people"));
        orderDto.setStartDateTime(request.getParameter("startDateTime"));
        orderDto.setEndDateTime(request.getParameter("endDateTime"));
        log.info(orderDto.toString());

        String email = session.getAttribute("email").toString();
        orderDto.setEmail(email);
        log.info("email : " + email);
        log.info(request.getParameter("people"));
        mv.setViewName("order/regionSelect");
        return mv;
    }

    @RequestMapping(value="/order/regionSelectB", method = RequestMethod.GET)
    public ModelAndView regionSelectB(HttpServletRequest request, OrderDto orderDto) throws Exception {
        log.info("regionSelect");
        log.info(request.getParameter("startDate").toString());
        log.info(request.getParameter("people").toString());
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        /*orderDto.setStartDate(request.getParameter("startDate"));
        orderDto.setEndDate(request.getParameter("endDate"));
        orderDto.setPeople(request.getParameter("people"));
        orderDto.setStartDateTime(request.getParameter("startDateTime"));
        orderDto.setEndDateTime(request.getParameter("endDateTime"));*/
        log.info(orderDto.getEndDate());

        String email = session.getAttribute("email").toString();
        orderDto.setEmail(email);
        request.setAttribute("orderDto", orderDto);
        log.info("email : " + email);
        log.info(request.getParameter("people"));
        mv.addObject("orderDto", orderDto);
        mv.setViewName("order/regionSelect");
        return mv;
    }

    @RequestMapping("/order/purchaseCheck")
    public ModelAndView purchaseCheck(HttpServletRequest request, OrderDto orderDto) throws Exception {
        log.info("purchaseCheck");
        ModelAndView mv = new ModelAndView();
        log.info(request.getParameter("people"));
        log.info(orderDto.getPeople());
        log.info(orderDto.getRegion());
        orderDto.setRegion(request.getParameter("region"));
        mv.addObject("orderDto", orderDto);
        mv.setViewName("order/purchaseCheck");
        return mv;
    }

    @RequestMapping("/order/purchasedTicket")
    public ModelAndView purchasedTicket(HttpRequest request, HttpResponse response, HttpSession session, OrderDto orderDto) {
        ModelAndView mv = new ModelAndView();
        log.info("regionSelect");
        session.getAttribute("email");
        mv.setViewName("order/regionSelect");
        return mv;
    }
}