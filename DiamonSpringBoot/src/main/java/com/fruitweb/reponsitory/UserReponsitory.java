package com.fruitweb.reponsitory;

import com.fruitweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReponsitory extends JpaRepository<User,Long> {

    User findUserByEmail(String email);

    User findUserByPassword(String password);

//    @Query(value = "select a from User a where a.email =:email and a.password =:password")
//    User getUserByUser(User user);



}
