package com.fruitweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fruitweb.model.Category;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category, Long> {	
	
	@Query(value = "SELECT * FROM categories WHERE category_id = ?1",nativeQuery = true)
	Category getCategoryById(Long id);
	


}
