package com.fruitweb.controller.admin;

import com.fruitweb.model.Category;
import com.fruitweb.service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CategoryAdminController {

    @Autowired
    private CategoryServiceImpl categoryService;

    private ModelAndView modelAndView = new ModelAndView();

    @GetMapping("/category")
    public ModelAndView categoryAdmin(@RequestParam("page") Optional<Integer> page){
        int pageNumber = page.orElse(0);
        if(pageNumber != 0) {
            pageNumber = pageNumber - 1;
        }
        Pageable pageable = PageRequest.of(pageNumber, 3);

        Page<Category> categories = categoryService.getAllCategoryPaging(pageable);

        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("categoryAdmin",categories);
        modelAndView.setViewName("/admin/category");
        return modelAndView;
    }

    @GetMapping("/addCategory")
    public ModelAndView viewFormAddCategoryAdmin(@ModelAttribute Category category){
        modelAndView.setViewName("/admin/Addcategory");
        modelAndView.addObject("categoryAdmin", new Category());
        return modelAndView;
    }

    @PostMapping("/addCategory")
    public ModelAndView addCategoryAdmin(@ModelAttribute("categoryAdmin") Category category){
        category = categoryService.save(category);
        modelAndView.setViewName("redirect:/category");
        return modelAndView;
    }

    @GetMapping("/updateCategory")
    public  ModelAndView viewUpdateCategory(){
        modelAndView.setViewName("/admin/UpadateCategory");
        return modelAndView;
    }

    @GetMapping("/updateCategory/{id}")
    public  ModelAndView editCategoryAdmin(@PathVariable Long id){
        ModelAndView modelAndView1 = new ModelAndView("update_category");
        Category category = categoryService.getById(id);
        modelAndView.addObject("updateCategory",category);
        return modelAndView;
    }


    @GetMapping("/deleteBook/{id}")
    public ModelAndView deleteBook(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        modelAndView.setViewName("redirect:/category");
        return modelAndView;
    }
}
