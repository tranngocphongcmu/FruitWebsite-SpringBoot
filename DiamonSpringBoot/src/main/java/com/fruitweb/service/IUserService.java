package com.fruitweb.service;

import com.fruitweb.model.User;

public interface IUserService {
//    int addUser(User user);
    int saveOrUpdate(User user);

    User checkAccount(User  user);

    User findUserByEmail(String email);

//    User checkUser(User user);

}
