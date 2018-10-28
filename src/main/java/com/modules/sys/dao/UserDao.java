package com.modules.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.modules.sys.entity.Classroom;
import com.modules.sys.entity.LackSeat;
import com.modules.sys.entity.User;

@Repository
public interface UserDao {

	public Integer insertUser(User user);

	public Integer deleteUserById(String id);
	
	public Integer updateUser(User user);

	public User queryUserById(String id);

	public List<User> queryAllUser();
	
	public User login(String digits, String password);
	
	public List<String> getCourseAllInfo();
	
	public List<String> getAllClassroomName();
	
	public Classroom getClassroomInfo(String location);
	
	public List<LackSeat> getFlaw(String location);

}
