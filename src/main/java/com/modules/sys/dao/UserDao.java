package com.modules.sys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.modules.sys.entity.User;

@Repository
public interface UserDao {

	public User queryUserById(@Param("id") String id);
	
}
