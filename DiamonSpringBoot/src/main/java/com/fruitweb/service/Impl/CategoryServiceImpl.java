package com.fruitweb.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return categoryReponsitory.save(category);
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

	@Override
	public Page<Category> getAllCategoryPaging(Pageable pageable) {
		return categoryReponsitory.findAll(pageable);
	}

	@Override
	public void saveAndUpdate(Category category) {
		if(category.getId() == null){
			categoryReponsitory.save(category);
		}else{
			Category category1 =  categoryReponsitory.findById(category.getId()).get();
			category1.setName(category.getName());
			categoryReponsitory.save(category1);

		}
	}

	@Override
	public Category getById(Long id) {
		return categoryReponsitory.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		 categoryReponsitory.deleteById(id);
	}

	@Override
	public Page<Category> searchCategoriesByName(String searchKey, Pageable pageable) {
		return categoryReponsitory.searchCategoriesByName(searchKey,pageable);
	}

	@Override
	public List<Category> getByKeyword(String keyword) {
		return categoryReponsitory.findByKeyword(keyword);
	}


}
