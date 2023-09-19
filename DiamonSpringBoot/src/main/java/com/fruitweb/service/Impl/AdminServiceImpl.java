package com.fruitweb.service.Impl;

import com.fruitweb.model.Admin;
import com.fruitweb.reponsitory.AdminReponsitory;
import com.fruitweb.reponsitory.UserReponsitory;
import com.fruitweb.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminReponsitory adminReponsitory;
    @Override
    public Page<Admin> getAllAdminPaging(Pageable pageable) {
        return adminReponsitory.findAll(pageable);
    }

    @Override
    public Admin getByID(Long id) {
        return adminReponsitory.findById(id).get();
    }

    @Override
    public Admin save(Admin admin) {
        return adminReponsitory.save(admin);
    }

    @Override
    public void deleteById(Long id) {
        adminReponsitory.deleteById(id);
    }

    @Override
    public List<Admin> getByKeyword(String keyword) {
        return adminReponsitory.findByKeyword(keyword);
    }

    @Override
    public List<Admin> getAllUser() {
        return adminReponsitory.findAll();
    }
}
