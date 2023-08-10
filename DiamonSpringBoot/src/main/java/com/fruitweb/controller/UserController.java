package com.fruitweb.controller;

import com.fruitweb.model.User;
import com.fruitweb.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserServiceImpl userService;

//    @RequestMapping(value = "/dang-ky",method = RequestMethod.GET)
    @GetMapping(value = "/dang-ky")
    public ModelAndView dangKy(){
        _mvShare.setViewName("/register");
        _mvShare.addObject("user",new User()); //
        return _mvShare;

    }

//    @RequestMapping(value = "/dang-ky",method = RequestMethod.POST)
    @PostMapping("/dang-ky")
    public ModelAndView createAcc(@ModelAttribute("user") User  user){
        int  count = userService.saveOrUpdate(user);
        if(count > 0){
            _mvShare.addObject("status","Dang Ky Tai Khoan Thanh Cong");
        }else {
            _mvShare.addObject("status","Dang Ky Tai Khoan That bai");
        }
        _mvShare.setViewName("/register");
        return _mvShare;

    }


//    @RequestMapping(value = "/dang-nhap",method = RequestMethod.POST)
    @PostMapping(value = "/dang-nhap")
    public ModelAndView login(@ModelAttribute("user") User  user, HttpSession session){
        user = userService.checkAccount(user);
        if (user != null){
            _mvShare.setViewName("redirect:index");
            session.setAttribute("logininfo",user);
        }else {
            _mvShare.addObject("statuslogin","Dang Nhap That Bai");
        }
        return _mvShare;

    }

//    @RequestMapping(value = "/dang-nhap",method = RequestMethod.GET)
    @GetMapping(value = "/dang-nhap")
    public ModelAndView dangNhap(){
        _mvShare.setViewName("/login");
        _mvShare.addObject("user",new User());
        return _mvShare;

    }

//    @RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
    @GetMapping("/dang-xuat")
    public ModelAndView logout(HttpSession session, HttpServletRequest request) {
        session.removeAttribute("logininfo");
        _mvShare.setViewName("index");
        return _mvShare;
    }

}
