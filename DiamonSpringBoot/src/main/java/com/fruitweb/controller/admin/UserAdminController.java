package com.fruitweb.controller.admin;

import com.fruitweb.model.Category;
import com.fruitweb.model.User;
import com.fruitweb.service.Impl.CategoryServiceImpl;
import com.fruitweb.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class UserAdminController {



    @Autowired
    private UserServiceImpl userService;

    private ModelAndView modelAndView = new ModelAndView();

    @GetMapping("/useradmin")
    public ModelAndView categoryAdmin(@RequestParam("page") Optional<Integer> page){
        int pageNumber = page.orElse(0);
        if(pageNumber != 0) {
            pageNumber = pageNumber - 1;
        }
        Pageable pageable = PageRequest.of(pageNumber, 3);

        Page<User> users = userService.getAllUserPaging(pageable);

        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("useradmin",users);
        modelAndView.setViewName("/admin/useradmin");
        return modelAndView;
    }




    @GetMapping("/addUser")
    public ModelAndView viewFormAddCategoryAdmin(@ModelAttribute User user){
        modelAndView.setViewName("/admin/Adduser");
        modelAndView.addObject("userAdmin", new User());
        return modelAndView;
    }


    @PostMapping("/addUser")
    public ModelAndView addCategoryAdmin(@ModelAttribute("userAdmin") User user){
        user = userService.save(user);
        modelAndView.setViewName("redirect:/useradmin");
        return modelAndView;
    }

    @GetMapping("/updateUser/{id}")
    public  ModelAndView viewUpdateUser(@PathVariable Long id){
        User user =  userService.getByID(id);
        modelAndView.addObject("updateuser",user);
        modelAndView.setViewName("/admin/updateuser");
        return modelAndView;
    }

    @PostMapping("/updateUser/{id}")
    public  ModelAndView editUserAdmin(@PathVariable Long id,@ModelAttribute("updateUsers") User user){
        user = userService.save(user);
        modelAndView.setViewName("redirect:/useradmin");
        return modelAndView;
    }


    @GetMapping("/deleteuser/{id}")
    public ModelAndView deleteBook(@PathVariable("id") Long id) {
        userService.deleteById(id);
        modelAndView.setViewName("redirect:/useradmin");
        return modelAndView;
    }

    @GetMapping("/get-single-user/{id}")
    public  ModelAndView getSingleUser(@PathVariable Long id, HttpSession session){
        User findByID = userService.getByID(id);
        User user = findByID;
        session.setAttribute("user",user);
        modelAndView.setViewName("/admin/singleuser");
        return modelAndView;
    }


    @RequestMapping("/searchuser")
    public ModelAndView home(User user, String keyword) {
        if(keyword!=null) {
            List<User> list = userService.getByKeyword(keyword);
            modelAndView.addObject("listuser", list);
        }else {
            List<User> list = userService.getAllUser();
            modelAndView.addObject("listuser", list);}
        modelAndView.setViewName("/admin/searchuser");
        return modelAndView;
    }

}
