package com.fruitweb.service;

import com.fruitweb.model.Admin;
import com.fruitweb.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAdminService {

    Page<Admin> getAllAdminPaging(Pageable pageable);

    Admin getByID(Long id);

    Admin save(Admin admin);

    void deleteById(Long id);
    List<Admin> getByKeyword(String keyword);

    List<Admin> getAllUser();
}
