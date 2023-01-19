package com.project1.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping("/index")
    public ModelAndView indexLogout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index2");
        return mv;
    }

}
