package com.modules.sys.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.common.utils.IdGen;
import com.modules.sys.dao.UserDao;
import com.modules.sys.entity.User;

@Service
@Transactional(readOnly = true)
public class UserService {

	@Autowired
	UserDao userDao;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//增加用户
	@Transactional(readOnly = false)
	public Integer insertUser(User user) {
		user.setId(IdGen.uuid());
		return userDao.insertUser(user);
	}
	
	// 根据id删除用户
	@Transactional(readOnly = false)
	public Integer deleteUserById(String id) {
		return userDao.deleteUserById(id);
	}
	
	@Transactional(readOnly = false)
	public Integer updateUser(User user) throws Exception {
		if (StringUtils.isEmpty(user.getId())) {
			throw new Exception("id为空或为null");
		}
//		user.setUpdateTime(sdf.format(new Date()));
		return userDao.updateUser(user);
	}

	// 根据id查找用户
	public User queryUserById(String id) {
		return userDao.queryUserById(id);
	}

	// 查找全部用户
	public List<User> queryAllUser() {
		return userDao.queryAllUser();
	}

}
