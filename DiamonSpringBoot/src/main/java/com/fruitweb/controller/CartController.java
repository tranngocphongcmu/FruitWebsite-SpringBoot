package com.fruitweb.controller;


import com.fruitweb.dto.CartItemDto;
import com.fruitweb.service.Impl.CartItemImpl;
import com.fruitweb.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/viewcart")
public class CartController  extends BaseController {

    @Autowired
    private CartItemImpl cartServiceImpl;

    @Autowired
    private ProductServiceImpl productService;


    @RequestMapping(value = "/cart",method = RequestMethod.GET)
    public String viewCart(){
        return "cart";
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public  String buy(@PathVariable("id") Long id, HttpSession session,HttpServletRequest request){
        List<CartItemDto> cart = new ArrayList<CartItemDto>();
        if (session.getAttribute("cart") == null){
            cart.add(new CartItemDto(productService.getProductById(id),1));
            session.setAttribute("cart",cart);
        }else {
            cart = (List<CartItemDto>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new CartItemDto(productService.getProductById(id),1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        int total = 0;
        for (CartItemDto itemDto: cart) {
            total += itemDto.getQuantity() * itemDto.getProduct().getCostPrice();
        }
        session.setAttribute("total",total);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public  String update(@PathVariable("id") Long id, HttpSession session,HttpServletRequest request){
            List<CartItemDto> cart = (List<CartItemDto>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            int quantity = cart.get(index).getQuantity() + 1;
            cart.get(index).setQuantity(quantity);
            session.setAttribute("cart", cart);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") Long id, HttpSession session,HttpServletRequest request) {
        List<CartItemDto> cart = (List<CartItemDto>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:" + request.getHeader("Referer");
    }



    private int exists(Long id, List<CartItemDto> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }







}
