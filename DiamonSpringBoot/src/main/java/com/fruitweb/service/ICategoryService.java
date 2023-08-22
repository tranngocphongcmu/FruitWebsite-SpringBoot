package com.fruitweb.service;

import java.util.List;
import java.util.Optional;

import com.fruitweb.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
	
	Category save(Category category);
	Category update(Category category);
	List<Category> getAllCategory();
	Category findCategoryById(Long id);

	Page<Category> getAllCategoryPaging(Pageable pageable);

	void saveAndUpdate(Category category);

	Category getById(Long id);

	void deleteById(Long id);

	Page<Category> searchCategoriesByName(String searchKey, Pageable pageable);

	List<Category> getByKeyword(String keyword);
	
	
	


}
