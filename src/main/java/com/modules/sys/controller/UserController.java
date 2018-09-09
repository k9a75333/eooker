package com.modules.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modules.sys.entity.User;
import com.modules.sys.service.UserService;

@Controller
@RequestMapping(value = "${adminPath}/sys/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/getUser")
	@ResponseBody
	public User queryUser(String id) {
		User user = userService.queryUserById(id);
		return user;
	}
	
	/**
	 * 根据用户id查询用户数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> queryUserById(@PathVariable("id") String id) {
		try {
			User user = userService.queryUserById(id);
			if (user == null) {
				//资源不存在 响应404
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			} 
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
}
