package com.modules.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.modules.sys.entity.User;

@Repository
public interface UserDao {

	public Integer insertUser(User user);

	public Integer deleteUserById(String id);
	
	public Integer updateUser(User user);

	public User queryUserById(String id);

	public List<User> queryAllUser();

}
