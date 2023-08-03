package com.fruitweb.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitweb.model.Menu;
import com.fruitweb.reponsitory.MenuReponsitory;
import com.fruitweb.service.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private MenuReponsitory menuReponsitory;

	@Override
	public List<Menu> getMenus() {
		return menuReponsitory.findAll();
	}

}
