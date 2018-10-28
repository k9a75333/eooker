package com.modules.sys.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.common.utils.IdGen;
import com.modules.sys.dao.UserDao;
import com.modules.sys.entity.Classroom;
import com.modules.sys.entity.LackSeat;
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
	
	//登录
	public User login (String digits, String password) {
		return userDao.login(digits, password);
	}
	
	//获取所有课程信息
	public List<String> getCourseAllInfo() {
		return userDao.getCourseAllInfo();
	}
	
	//获取所有课室位置（名字）
	public List<String> getAllClassroomName() {
		return userDao.getAllClassroomName();
	}
	
	/**
	 * 获取房间的所有信息
	 * @param location
	 * @return
	 */
	public Map<String, Object> getSpecificRoomInfo(String location) {
		Map<String, Object> map = new HashMap<String, Object>();
		Classroom room = userDao.getClassroomInfo(location);
		room.setId(null);
		if (room.getIsFlaw().equals("0")) {
			map.put("room_basic_info", room);
		} else {
			List<LackSeat> list = userDao.getFlaw(location);
			map.put("room_basic_info", room);
			map.put("flaw_info", list);
		}
		return map;
	}

}
