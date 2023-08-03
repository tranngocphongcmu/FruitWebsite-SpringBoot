package com.fruitweb.controller;

import java.util.List;
import java.util.Optional;

import com.fruitweb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fruitweb.model.Category;
import com.fruitweb.service.Impl.CategoryServiceImpl;
import com.fruitweb.service.Impl.ProductServiceImpl;

@Controller
public class HomeController extends BaseController {


	@Autowired
	private ProductServiceImpl productServiceImpl;

	@RequestMapping(value = {"/","/index"})
	public ModelAndView homePage(@RequestParam("page") Optional<Integer> page) {

		int pageNumber = page.orElse(0);
		if(pageNumber != 0) {
			pageNumber = pageNumber - 1;
		}
		Pageable pageable = PageRequest.of(pageNumber, 6);

		Page<Product> products = productServiceImpl.findAllProduct(pageable);

		List<Product> productSlides = productServiceImpl.getAllProducts();

		_mvShare.addObject("page", pageNumber);
		_mvShare.addObject("menus", _menuServiceImpl.getMenus());
		_mvShare.addObject("categorys", _categoryServiceImpl.getAllCategory());
		_mvShare.addObject("products", products);
		_mvShare.addObject("productSlides", productSlides);
		_mvShare.setViewName("/index");
		return _mvShare;
	}










}
