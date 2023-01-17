package com.project1.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class OrderController {

    @Resource(name = "orderService")
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
        mv.addObject("orderDto", orderDto);
        mv.setViewName("order/regionSelect");
        return mv;
    }

    @RequestMapping("/order/purchaseCheck")
    public ModelAndView purchaseCheck(HttpServletRequest request, OrderDto orderDto, ModelAndView mv) throws Exception {
        log.info("purchaseCheck");
        orderDto.setRegion(request.getParameter("region"));
        request.setAttribute("orderDto", orderDto);
        mv.addObject("orderDto", orderDto);
        log.info(orderDto.getEmail());
        log.info(orderDto.getPeople());
        mv.setViewName("order/purchaseCheck");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/order/purchasedTicketA")
    public ModelAndView purchasedTicketA(OrderDto orderDto, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        PurchaseDto purchaseDto;
        log.info("purchasedTicketA");

        try {
            purchaseDto = orderService.purchaseTicket(orderDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info(purchaseDto.getPurchaseSerial());
        log.info(orderDto.getEmail());
        request.setAttribute("orderDto", orderDto);
        request.setAttribute("purchaseDto", purchaseDto);
        mv.setViewName("order/purchaseDtoPage");
        session.setAttribute("purchaseDto", purchaseDto);
        return mv;
    }

    @RequestMapping("/order/purchasedTicketB")
    public ModelAndView purchasedTicketB(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PurchaseDto purchaseDto = (PurchaseDto) session.getAttribute("purchaseDto");
        log.info("purchasedTicketB");
        log.info(purchaseDto.getPurchaseSerial());
        request.setAttribute("purchaseDto", purchaseDto);
        session.removeAttribute("purchaseDto");
        mv.setViewName("order/purchasedTicket");
        return mv;
    }
}