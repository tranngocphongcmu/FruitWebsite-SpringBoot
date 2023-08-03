package com.fruitweb.controller;

import com.fruitweb.model.Bills;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PaymentController extends BaseController {

    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public ModelAndView checkout(HttpServletRequest request, HttpSession session){
        _mvShare.setViewName("/checkout");
        _mvShare.addObject("bills",new Bills());
        return _mvShare;
    }

    @RequestMapping(value = "/checkout",method = RequestMethod.POST)
    public ModelAndView checkout(@ModelAttribute("bills") Bills bills, HttpServletRequest request, HttpSession session){
        _mvShare.setViewName("/checkout");
        return _mvShare;
    }
}
