package com.bishwajit.simplesearchapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public ModelAndView getHome(){
        return  new ModelAndView("home");
    }

    @RequestMapping(value = {"/apiList"},method = RequestMethod.GET)
    public ModelAndView getAPI(){
        return  new ModelAndView("apiList");
    }
}
