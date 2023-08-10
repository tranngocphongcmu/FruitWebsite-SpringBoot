package com.fruitweb.controller.admin;


import com.fruitweb.model.Category;
import com.fruitweb.model.Product;
import com.fruitweb.service.Impl.CategoryServiceImpl;
import com.fruitweb.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminHomeController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductServiceImpl productService;
    private ModelAndView modelAndView = new ModelAndView();

    @GetMapping("/adminhome")
    public ModelAndView adminHome(@RequestParam("page") Optional<Integer> page){
        int pageNumber = page.orElse(0);
        if(pageNumber != 0) {
            pageNumber = pageNumber - 1;
        }
        Pageable pageable = PageRequest.of(pageNumber, 10);

        Page<Product> products = productService.findAllProduct(pageable);

        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("productsAdmin",products);
        modelAndView.setViewName("/admin/adminhome");
        return modelAndView;
    }


}
