package com.fruitweb.reponsitory;

import com.fruitweb.model.Admin;
import com.fruitweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminReponsitory extends JpaRepository<Admin,Long> {

    @Query(value = "select * from admins s where s.username like %:keyword%", nativeQuery = true)
    List<Admin> findByKeyword(@Param("keyword") String keyword);
}
