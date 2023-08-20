package com.fruitweb.service.Impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fruitweb.model.Category;
import com.fruitweb.model.Product;
import com.fruitweb.reponsitory.ProductReponsitory;
import com.fruitweb.service.IProductService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements IProductService {

	private List<Product> products;
	
	@Autowired
	ProductReponsitory productReponsitory;


//	@Override
//	public Product saveProductToDB(Product product, MultipartFile file) {
//		Product p = new Product();
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		if(fileName.contains(".."))
//		{
//			System.out.println("not a a valid file");
//		}
//		try {
//			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		p.setDescription(description);
//
//		p.setName(name);
//		p.setPrice(price);
//
//		productRepo.save(p);
//	}

	@Override
	public Page<Product> findByName(String name, Pageable pageable) {
		return productReponsitory.findByName(name,pageable);
	}

	@Override
	public Page<Product> getAllProductsFindPage(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber -1, 6);
		return productReponsitory.findAll(pageable);
	}

	@Override
	public List<Product> getAllProducts() {
		return productReponsitory.findAll();
	}

	@Override
	public Page<Product> searchProductByName(String searchKey, Pageable pageable) {
		return productReponsitory.searchProductByName(searchKey,pageable);
	}

	@Override
	public Page<Product> findAllProduct(Pageable pageable) {
		return productReponsitory.findAll(pageable);
	}


	@Override
	public Page<Product> findProductByCategory(Category category, Pageable pageable) {
		return productReponsitory.findProductByCategory(category, pageable);
	}

	@Override
	public Page<Product> findProduct(Product product, Pageable pageable) {
		return null;
	}


	@Override
	public Product getProductByCategoryId(Long id) {
		return productReponsitory.findById(id).get();
	}

	@Override
	public List<Product> getListProductByCategoryId(Long id) {
		return productReponsitory.getListProductByCategoryId(id);
	}



	@Override
	public Optional<Product> findById(Long id) {
		return productReponsitory.findById(id);
	}

	@Override
	public List<Product> findProductsWithSorting(String field) {
		return productReponsitory.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	@Override
	public Page<Product> findProductsWithPagination(int offset, int pageSize) {
		Page<Product> products = productReponsitory.findAll(PageRequest.of(offset,pageSize));
		return products;
	}

	@Override
	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field,String key) {
		Sort sort =  Sort.by(Sort.Direction.ASC, field);
		if("thap-cao".equals(key)){
			 sort = Sort.by(Sort.Direction.DESC, field);
		}
		Page<Product>  products = productReponsitory.findAll(PageRequest.of(offset,pageSize).withSort(sort));
		return products;
	}


	//hoan chinh

	@Override
	public Product getProductById(Long id) {
		return productReponsitory.findById(id).get();
	}


	@Override
	public Product saveProduct(Product product) {
		return productReponsitory.save(product);
	}


	@Override
	public void deleteProductById(Long id) {
		productReponsitory.deleteById(id);
	}

	@Override
	public Product getProductID(Long id) {

		Optional<Product> optional = productReponsitory.findById(id);
		Product product = null;
		if (optional.isPresent()){
			product = optional.get();
		}else {
			throw new RuntimeException("Product not found for id : "+ id);
		}
		return product;
	}

	@Override
	public List<Product> getAllProduct(String keyWord) {
		if (keyWord != null){
			return productReponsitory.findAll();
		}else {
			return productReponsitory.findAll();
		}
	}

	@Override
	public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending(): Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1 ,pageSize,sort);
		return productReponsitory.findAll(pageable);
	}

//	@Override
//	public List<Product> findAllByPrice(double costPrice, Pageable pageable) {
//		return productReponsitory.findAllByPrice(costPrice,pageable);
//	}


}
