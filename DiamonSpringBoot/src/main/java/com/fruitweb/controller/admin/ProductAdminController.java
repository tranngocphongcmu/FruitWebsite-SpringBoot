package com.fruitweb.controller.admin;

import com.fruitweb.dto.ProductDto;
import com.fruitweb.model.Category;
import com.fruitweb.model.Product;
import com.fruitweb.service.Impl.CategoryServiceImpl;
import com.fruitweb.service.Impl.ProductServiceImpl;
import com.fruitweb.ultis.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductAdminController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl categoryService;
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/assets/img/product";
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
        modelAndView.setViewName("/redirect:/adminhome");
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


//    //crudstaff
//
//    //
//    @GetMapping("/addProduct")
//    public ModelAndView viewAddProduct2(){
//        ProductDto productDto = new ProductDto();
//        modelAndView.addObject("productDtoAdmin",productDto);
//        modelAndView.setViewName("/admin/AddProductAdmin");
//        return modelAndView;
//    }
//
//    @PostMapping("/saveOrUpdate")
//    public  ModelAndView saveP(@ModelAttribute("productDtoAdmin") ProductDto dto){
//
//        Optional<Product> optionalProduct = productService.findById(dto.getId());
//        Product product = null;
//
//
//        String image = "cachua.jpg";
//        Path path = Paths.get("/assets/img/product/");
//
//        if(optionalProduct.isPresent()){
////            save
//        }else {
//            if(!dto.getImage().isEmpty()){
//                try {
//                    InputStream inputStream = dto.getImage().getInputStream();
//                    Files.copy(inputStream,path.resolve(dto.getImage().getOriginalFilename()),
//                            StandardCopyOption.REPLACE_EXISTING);
//                    image = dto.getImage().getOriginalFilename().toString();
//                }catch (Exception e){
//
//                    e.printStackTrace();
//                }
//            }
//        }
//        product = new Product(dto.getId(),dto.getName(),dto.getCurrentQuantity(),dto.getCostPrice(),dto.getSalePrice(),dto.getImage());
//        productService.saveProduct(product);
//        modelAndView.setViewName("/redirect:/adminhome");
//        return modelAndView;
//    }
}
