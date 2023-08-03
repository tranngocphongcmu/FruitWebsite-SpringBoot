package com.fruitweb.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitweb.model.Category;
import com.fruitweb.reponsitory.CategoryReponsitory;
import com.fruitweb.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryReponsitory categoryReponsitory;

	@Override
	public Category save(Category category) {
		return null;
	}


	@Override
	public List<Category> getAllCategory() {
		return categoryReponsitory.findAll();
	}


	@Override
	public Category update(Category category) {
		return null;
	}


	@Override
	public Category findCategoryById(Long id) {
		return categoryReponsitory.getCategoryById(id);
	}





}
