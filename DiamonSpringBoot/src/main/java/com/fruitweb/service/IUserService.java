package com.fruitweb.service;

import com.fruitweb.model.Category;
import com.fruitweb.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
//    int addUser(User user);
    int saveOrUpdate(User user);

    User checkAccount(User  user);

    User findUserByEmail(String email);

    Page<User> getAllUserPaging(Pageable pageable);

    User getByID(Long id);

    User save(User user);

    void deleteById(Long id);
    List<User> getByKeyword(String keyword);

    List<User> getAllUser();
//    User checkUser(User user);

}
