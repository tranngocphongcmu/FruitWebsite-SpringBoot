package com.fruitweb.reponsitory;

import com.fruitweb.model.Category;
import com.fruitweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserReponsitory extends JpaRepository<User,Long> {

    User findUserByEmail(String email);

    User findUserByPassword(String password);

    @Query(value = "select * from users s where s.name like %:keyword%", nativeQuery = true)
    List<User> findByKeyword(@Param("keyword") String keyword);

//    @Query(value = "select a from User a where a.email =:email and a.password =:password")
//    User getUserByUser(User user);



}
