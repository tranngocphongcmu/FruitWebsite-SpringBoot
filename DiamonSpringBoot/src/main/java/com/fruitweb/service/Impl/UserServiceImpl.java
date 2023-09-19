package com.fruitweb.service.Impl;

import com.fruitweb.model.User;
import com.fruitweb.reponsitory.UserReponsitory;
import com.fruitweb.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserReponsitory userReponsitory;

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

    @Override
    public Page<User> getAllUserPaging(Pageable pageable) {
        return userReponsitory.findAll(pageable);
    }

    @Override
    public User getByID(Long id) {
        return userReponsitory.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userReponsitory.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userReponsitory.deleteById(id);
    }

    @Override
    public List<User> getByKeyword(String keyword) {
        return userReponsitory.findByKeyword(keyword);
    }

    @Override
    public List<User> getAllUser() {
        return userReponsitory.findAll();
    }


}
