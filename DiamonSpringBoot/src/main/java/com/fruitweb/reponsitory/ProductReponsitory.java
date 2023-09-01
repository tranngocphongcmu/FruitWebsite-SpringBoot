package com.fruitweb.reponsitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fruitweb.model.Category;
import com.fruitweb.model.Product;
	
@Repository
public interface ProductReponsitory extends JpaRepository<Product, Long> {


//	@Query("SELECT Product FROM Product product  WHERE concat(product.id,product.name,product.costPrice) like %?1%")
//	List<Product> searchProductByKeyWord(String keyWord);
	Product findProductsByName(String productName);


	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
	Page<Product> searchProductByName(String searchKey, Pageable pageable);

	@Query("select p from Product p where p.name like %?1%")
	Page<Product> findByName(String name, Pageable pageable);

	Product getProductById(Long id);


	@Query(value = "SELECT * FROM products limit 5",nativeQuery = true)
	List<Product> findByProductSlider();



//	List<Product> findAllByPrice(double costPrice, Pageable pageable);


	Product getProductByCategoryId(Long id);

	Page<Product>  findProductByCategory(Category category, Pageable pageable);

	@Query(value = "select p from Product  p inner  join  Category c on  p.category.id = ?1 and c.id  = ?1")
	List<Product> getListProductByCategoryId(Long id);

	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%" + " OR p.name LIKE %?1%")
	Page<Product> search(String searchKey, Pageable pageable);

	@Query(value = "select " +
			"p.product_id, p.name, p.description, p.current_quantity, p.cost_price, p.category_id, p.sale_price, p.image, p.is_activated, p.is_deleted " +
			"from products p where p.is_activated = true and p.is_deleted = false order by rand() limit 9", nativeQuery = true)
	List<Product> randomProduct();


	@Query(value = "select * from products p where p.name like %:keyword%", nativeQuery = true)
	List<Product> findByKeywordproduct(@Param("keyword") String keyword);


}

