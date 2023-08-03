package com.fruitweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fruitweb.model.Menu;

@Repository
public interface MenuReponsitory extends JpaRepository<Menu, Long> {

}
