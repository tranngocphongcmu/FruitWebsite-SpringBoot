package com.fruitweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fruitweb.model.Category;
import com.fruitweb.model.Product;

public interface IProductService {

	Page<Product> findByName(String name, Pageable pageable);

	Page<Product> getAllProductsFindPage(int pageNumber);
	
	List<Product> getAllProducts();

	Page<Product> searchProductByName(String searchKey, Pageable pageable);
	Page<Product> findAllProduct(Pageable pageable);
	
	Page<Product>  findProductByCategory(Category category, Pageable pageable);
	Page<Product> findProduct(Product product, Pageable pageable);
//	List<Product> findAllByPrice(double costPrice, Pageable pageable);
	Product getProductByCategoryId(Long id);

	List<Product> getListProductByCategoryId(Long id);

	Product getProductById(Long id);

	Optional<Product> findById(Long id);

	List<Product> findProductsWithSorting(String field);
	Page<Product> findProductsWithPagination(int offset,int pageSize);
	Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String field,String key);



}
