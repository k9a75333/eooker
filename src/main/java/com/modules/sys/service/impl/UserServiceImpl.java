package com.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.sys.dao.UserDao;
import com.modules.sys.entity.User;
import com.modules.sys.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User queryUserById(String id) {
		return userDao.queryUserById(id);
	}

}
