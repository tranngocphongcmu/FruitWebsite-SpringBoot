package com.fruitweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fruitweb.model.Category;
import com.fruitweb.model.Product;
import org.springframework.web.multipart.MultipartFile;

public interface IProductService {

//	Product saveProductToDB(Product product, MultipartFile file);


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



	Optional<Product> findById(Long id);

	List<Product> findProductsWithSorting(String field);
	Page<Product> findProductsWithPagination(int offset,int pageSize);
	Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String field,String key);
	Product getProductById(Long id);

//	hoanf chinh

	Product saveProduct(Product product);
	void deleteProductById(Long id);

	Product getProductID(Long id);

	List<Product> getAllProduct(String keyWord);
	Page<Product> findPaginated(int pageNo,int pageSize,String sortField,String sortDir);

	List<Product> findByKeywordproduct(String keyword);

}
