package com.fruitweb.reponsitory;

import com.fruitweb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fruitweb.model.Category;

import java.util.List;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category, Long> {	
	
	@Query(value = "SELECT * FROM categories WHERE category_id = ?1",nativeQuery = true)
	Category getCategoryById(Long id);


	@Query(value = "SELECT c FROM categories c WHERE c.name LIKE %?1%",nativeQuery = true)
	Page<Category> searchCategoriesByName(String searchKey, Pageable pageable);

	//Custom query
	@Query(value = "select * from categories s where s.name like %:keyword%", nativeQuery = true)
	List<Category> findByKeyword(@Param("keyword") String keyword);
	


}
