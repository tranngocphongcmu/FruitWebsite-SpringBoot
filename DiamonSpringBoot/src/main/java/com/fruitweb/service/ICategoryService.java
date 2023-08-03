package com.fruitweb.service;

import java.util.List;
import java.util.Optional;

import com.fruitweb.model.Category;

public interface ICategoryService {
	
	Category save(Category category);
	Category update(Category category);
	List<Category> getAllCategory();
	Category findCategoryById(Long id);
	
	
	


}
