package com.fruitweb.service.Impl;

import com.fruitweb.model.User;
import com.fruitweb.reponsitory.UserReponsitory;
import com.fruitweb.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserReponsitory userReponsitory;
//    @Override
//    public int addUser(User user) {
//
//        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
//        return userReponsitory.addUser(user);
//    }

    @Override
    public int saveOrUpdate(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
        userReponsitory.save(user);
        return 0;
    }

    @Override
    public  User checkAccount(User user) {
        String pass = user.getPassword();
        user = userReponsitory.findUserByEmail(user.getEmail());
        if (user != null){
            if(BCrypt.checkpw(pass,user.getPassword())){
                return user;
            }else {
                return null;
            }
        }
        return null;
    }


    @Override
    public User findUserByEmail(String email) {
        return userReponsitory.findUserByEmail(email);
    }

//    @Override
//    public User checkUser(User user) {
//        String pass = user.getPassword();
//        user = userReponsitory.getUserByUser(user);
//        if (user != null){
//            if(BCrypt.checkpw(pass,user.getPassword())){
//                return user;
//            }else {
//                return null;
//            }
//        }
//        return null;
//    }


}
