package com.fruitweb.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.fruitweb.service.Impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

import com.fruitweb.model.Category;
import com.fruitweb.model.Product;
import com.fruitweb.service.Impl.CategoryServiceImpl;
import com.fruitweb.service.Impl.ProductServiceImpl;

@Controller
@RequestMapping()
public class ProductController extends  BaseController {
	
	@Autowired
	private  CategoryServiceImpl categoryService;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Autowired
	MenuServiceImpl _menuServiceImpl;

	
	@RequestMapping("/san-pham/{id}")
    public ModelAndView getProductByCategory(@PathVariable Long id, @RequestParam("page") Optional<Integer> page){
		int pageNumber = page.orElse(0);
		if(pageNumber != 0) {
			pageNumber = pageNumber - 1;
		}
        Pageable pageable = PageRequest.of(pageNumber, 3);
        Category category = categoryService.findCategoryById(id);
        Page<Product> products = productServiceImpl.findProductByCategory(category,pageable);
        _mvShare.addObject("products", products);
		_mvShare.addObject("page", pageNumber);
		_mvShare.addObject("menus", _menuServiceImpl.getMenus());
		_mvShare.addObject("categorys", _categoryServiceImpl.getAllCategory());
		_mvShare.setViewName("/product");
        return _mvShare;

    }

	@GetMapping("/search/")
	public ModelAndView searchProduct(@RequestParam String keySearch, @RequestParam("page") Optional<Integer> page){
		int pageNumber = page.orElse(0);
		if(pageNumber != 0) {
			pageNumber = pageNumber - 1;
		}
		Pageable pageable = PageRequest.of(pageNumber, 3);
		Page<Product> products = productServiceImpl.searchProductByName(keySearch,pageable);
		_mvShare.addObject("products", products);
		_mvShare.addObject("page", pageNumber);
		_mvShare.addObject("menus", _menuServiceImpl.getMenus());
		_mvShare.addObject("categorys", _categoryServiceImpl.getAllCategory());
		_mvShare.addObject("searching", products);
		_mvShare.addObject("keySearch", keySearch);
		_mvShare.setViewName("/searchProduct");
		return _mvShare;

	}

	@GetMapping("/search-paging/{keySearch}")
	public ModelAndView searchPaging(@PathVariable String keySearch, @RequestParam("page") Optional<Integer> page){
		int pageNumber = page.orElse(0);
		if(pageNumber != 0) {
			pageNumber = pageNumber - 1;
		}
		Pageable pageable = PageRequest.of(pageNumber, 3);
		Page<Product> products = productServiceImpl.searchProductByName(keySearch,pageable);
		_mvShare.addObject("products", products);
		_mvShare.addObject("page", pageNumber);
		_mvShare.addObject("menus", _menuServiceImpl.getMenus());
		_mvShare.addObject("categorys", _categoryServiceImpl.getAllCategory());
		_mvShare.addObject("searching", products);
		_mvShare.addObject("keySearch", keySearch);
		_mvShare.setViewName("/searchProduct");
		return _mvShare;

	}



	@GetMapping("/chi-tiet-san-pham/{id}")
	public ModelAndView getProductDetails(@PathVariable Long id){
		_mvShare.addObject("productdetails",productServiceImpl.getProductByCategoryId(id));
		_mvShare.addObject("productByIdCategory",productServiceImpl.getListProductByCategoryId(id));
		_mvShare.setViewName("/productdetails");
		return _mvShare;
	}


	@GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}/{key}")
	public ModelAndView getProductsWithPaginationAndSort(@PathVariable int offset,
												  @PathVariable int pageSize,
												  @PathVariable String field,
													@PathVariable String key) {
		Page<Product> productsWithPagination = productServiceImpl.findProductsWithPaginationAndSorting(offset, pageSize, field,key);

		_mvShare.addObject("products",productsWithPagination);
		_mvShare.setViewName("/product");
		return _mvShare;
	}



}
