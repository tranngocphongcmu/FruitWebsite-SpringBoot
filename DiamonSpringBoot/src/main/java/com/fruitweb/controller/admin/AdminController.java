package com.fruitweb.controller.admin;


import com.fruitweb.model.Admin;
import com.fruitweb.model.Category;
import com.fruitweb.model.Product;
import com.fruitweb.model.User;
import com.fruitweb.service.Impl.AdminServiceImpl;
import com.fruitweb.service.Impl.UserServiceImpl;
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
public class AdminController {


    @Autowired
    private AdminServiceImpl adminService;

    private ModelAndView modelAndView = new ModelAndView();

    @GetMapping("/adminaccount")
    public ModelAndView adminAdmin(@RequestParam("page") Optional<Integer> page){
        int pageNumber = page.orElse(0);
        if(pageNumber != 0) {
            pageNumber = pageNumber - 1;
        }
        Pageable pageable = PageRequest.of(pageNumber, 3);

        Page<Admin> admins = adminService.getAllAdminPaging(pageable);

        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("adminaccounts",admins);
        modelAndView.setViewName("/admin/adminaccount");
        return modelAndView;
    }





    @GetMapping("/addadmin")
    public ModelAndView viewAddAdmin(){
        Admin admin = new Admin();
        modelAndView.addObject("adminaccounts",admin);
        modelAndView.setViewName("/admin/addadmin");
        return modelAndView;
    }



    @PostMapping("/saveAdmin")
    public ModelAndView saveProduct(@ModelAttribute("adminaccounts") Admin admin,
                                    @RequestParam("file")MultipartFile multipartFile,
                                    HttpServletRequest request
                                   ) throws IOException{
        String  fileName = "";
        try {
            fileName = FileUtil.upload(multipartFile,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        admin.setImage(fileName);
        Admin admin1 = adminService.save(admin);
        modelAndView.setViewName("redirect:/adminaccount");
        return modelAndView;
    }

    @GetMapping("/updateAdmin/{id}")
    public  ModelAndView viewUpdateAdmin(@PathVariable Long id){
        Admin admin = adminService.getByID(id);
        modelAndView.addObject("updateadmin",admin);
        modelAndView.setViewName("/admin/updateadmin");
        return modelAndView;
    }

    @PostMapping("/updateAdmin/{id}")
    public  ModelAndView editAdmin(@PathVariable Long id,
                                           @ModelAttribute("updateadminaccounts") Admin  admin,
                                           HttpServletRequest request,
                                           @RequestParam("file")MultipartFile multipartFile
                                           ){
        String fileName = "";
        try {
            fileName = FileUtil.upload(multipartFile,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        admin.setImage(fileName);
        Admin admin1 = adminService.save(admin);
        modelAndView.setViewName("redirect:/adminaccount");
        return modelAndView;
    }



    @GetMapping("/deleteAdmin/{id}")
    public  ModelAndView deleteAdmin(@PathVariable("id") Long id){
        adminService.deleteById(id);
        modelAndView.setViewName("redirect:/adminaccount");
        return modelAndView;
    }


    @GetMapping("/get-single-admin/{id}")
    public  ModelAndView getSingleAdmin(@PathVariable Long id, HttpSession session){
        Admin findByID = adminService.getByID(id);
        Admin admin = findByID;
        session.setAttribute("admin",admin);
        modelAndView.setViewName("/admin/singleadmin");
        return modelAndView;
    }


    @RequestMapping("/searchadmin")
    public ModelAndView home(Admin admin, String keyword) {
        if(keyword!=null) {
            List<Admin> list = adminService.getByKeyword(keyword);
            modelAndView.addObject("listadmin", list);
        }else {
            List<Admin> list = adminService.getAllUser();
            modelAndView.addObject("listadmin", list);}
        modelAndView.setViewName("/admin/searchadmin");
        return modelAndView;
    }

}
