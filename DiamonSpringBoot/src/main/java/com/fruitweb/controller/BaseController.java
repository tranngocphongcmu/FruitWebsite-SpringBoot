package com.fruitweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import com.fruitweb.service.Impl.SlideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.fruitweb.model.Category;
import com.fruitweb.service.Impl.CategoryServiceImpl;
import com.fruitweb.service.Impl.MenuServiceImpl;

@Controller
public class BaseController {
	
	@Autowired
	 CategoryServiceImpl _categoryServiceImpl;
	
	@Autowired
	 MenuServiceImpl _menuServiceImpl;

	@Autowired
	SlideServiceImpl _slideService;

	
	public ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Init() {
		List<Category> categories = _categoryServiceImpl.getAllCategory();
		_mvShare.addObject("categorys", categories);
		_mvShare.addObject("menus", _menuServiceImpl.getMenus());
		_mvShare.addObject("slides",_slideService.getSlides());
		return _mvShare;
	}

}
