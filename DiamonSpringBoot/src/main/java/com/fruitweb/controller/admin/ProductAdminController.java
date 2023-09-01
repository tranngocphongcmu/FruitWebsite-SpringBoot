package com.fruitweb.controller.admin;

import com.fruitweb.model.Category;
import com.fruitweb.model.Product;
import com.fruitweb.service.Impl.CategoryServiceImpl;
import com.fruitweb.service.Impl.ProductServiceImpl;
import com.fruitweb.ultis.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductAdminController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl categoryService;
    private ModelAndView modelAndView = new ModelAndView();

    @GetMapping("/addProduct")
    public ModelAndView viewAddProduct(){
        Product product = new Product();
        List<Category> category = categoryService.getAllCategory();
        modelAndView.addObject("productAdmin",product);
        modelAndView.addObject("listCategory",category);
        modelAndView.setViewName("/admin/AddProductAdmin");
        return modelAndView;
    }



    @PostMapping("/saveProduct")
    public ModelAndView saveProduct(@ModelAttribute("productAdmin") Product product,
                                    @RequestParam("file")MultipartFile multipartFile,
                                    HttpServletRequest request,
                                    Long category_id) throws IOException{
        Category category = categoryService.findCategoryById(category_id);
        String fileName = "";
        try {
            fileName = FileUtil.upload(multipartFile,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(fileName);
        product.setCategory(category);
        Product saveProduct = productService.saveProduct(product);
        modelAndView.setViewName("redirect:/adminhome");
        return modelAndView;
    }

    @GetMapping("/updateProduct/{id}")
    public  ModelAndView viewUpdateCategory(@PathVariable Long id){
        Product product = productService.findById(id).get();
        modelAndView.addObject("updateproduct",product);
        modelAndView.setViewName("/admin/updateproductadmin");
        return modelAndView;
    }

    @PostMapping("/updateProduct/{id}")
    public  ModelAndView editCategoryAdmin(@PathVariable Long id,
                                           @ModelAttribute("updateproductadmin") Product  product,
                                           HttpServletRequest request,
                                           @RequestParam("file")MultipartFile multipartFile,
                                           Long category_id){
        Category category = categoryService.findCategoryById(category_id);
        String fileName = "";
        try {
            fileName = FileUtil.upload(multipartFile,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(fileName);
        product.setCategory(category);
        Product saveProduct = productService.saveProduct(product);
        modelAndView.setViewName("redirect:/adminhome");
        return modelAndView;
    }


    @GetMapping("/showFormForUpdate/{id}")
    public  ModelAndView updateImage(@PathVariable("id") Long id){
//        get product from the service
        Product product = productService.getProductById(id);

        //set product
        modelAndView.addObject("product",product);
        modelAndView.setViewName("/admin/editProductAdmin");
        return modelAndView;
    }

    @GetMapping("/deleteProduct/{id}")
    public  ModelAndView deleteProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        modelAndView.setViewName("redirect:/adminhome");
        return modelAndView;
    }


    @GetMapping("/page/{pageNo}")
    public ModelAndView findPaginated(@PathVariable("pageNo") int pageNo,
                                      @RequestParam("sortField") String sortField,
                                      @RequestParam("sortDir") String sortDir){
        int pageSize = 3;
        Page<Product> page = productService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<Product> listProduct = page.getContent();

        modelAndView.addObject("currentPage",pageNo);
        modelAndView.addObject("totalPages",page.getTotalPages());
        modelAndView.addObject("totalItems",page.getTotalElements());

        modelAndView.addObject("sortField",sortField);
        modelAndView.addObject("sortDir",sortDir);
        modelAndView.addObject("reverseSortDir",sortDir.equals("asc") ? "desc" : "asc");

        modelAndView.addObject("listProduct",listProduct);
        modelAndView.setViewName("/admin/adminhome");

        return modelAndView;
    }

    @GetMapping("/getsingleproduct/{id}")
    public  ModelAndView getSingleProduct(@PathVariable Long id, HttpSession session){
        Product findByID = productService.findById(id).get();
        Product product = findByID;
        session.setAttribute("product",product);
        modelAndView.setViewName("/admin/singleproduct");
        return modelAndView;
    }

    @GetMapping("/searchproduct")
    public ModelAndView home(Product product, String keyword) {
        if(keyword!=null) {
            List<Product> list = productService.findByKeywordproduct(keyword);
            modelAndView.addObject("listproduct", list);
        }else {
            List<Product> list = productService.getAllProducts();
            modelAndView.addObject("listproduct", list);}
        modelAndView.setViewName("/admin/searchproduct");
        return modelAndView;
    }


}
