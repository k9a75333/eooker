package com.modules.sys.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.utils.Result;
import com.modules.sys.entity.User;
import com.modules.sys.service.UserService;

/**
 * 用户接口的Controller
 * (用户的所有接口都包含在这个Controller，包括对用户基本信息的增删改查的接口)
 * GET 用来获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE 用来删除资源。
 * @author LIUYU
 * @version 2018-06-01
 */
@Controller
@RequestMapping("${adminPath}/sys/userAPI")
public class UserAPIController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	@PostMapping("/users")
	@ResponseBody
	public Result addUser(@RequestBody User user) {
		try {
			userService.insertUser(user);
		} catch (Exception e) {
			return Result.makeFailResult("插入失败");
		}
		return Result.makeSuccessResult("插入成功");
	}
	
	/**
	 * 删除指定用户
	 * @param id
	 * @return
	 */
	@DeleteMapping("/users/{id}")
	@ResponseBody
	public Result deleteUser(@PathVariable(value = "id") String id) {
		int affectRows = userService.deleteUserById(id);
		if (affectRows == 1) {
			return Result.makeSuccessResult("删除成功");
		} else {
			return Result.makeFailResult("该用户不存在");
		}
	}
	
	/**
	 * 修改指定用户的数据
	 * @param user
	 * @return
	 */
	@PutMapping("/users")
	@ResponseBody
	public Result alterUser(@RequestBody User user) {
		int affectRows;
		try {
			affectRows = userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			//id为空等情况
			return Result.makeFailResult("数据异常");
		}
		if (affectRows == 1) {
			return Result.makeSuccessResult("修改成功");
		} else {
			return Result.makeFailResult("该用户不存在");
		}
	}
	
	/**
	 * 查找用户数据   id为空则查找全部用户，否则查找指定用户
	 * @param id
	 * @return
	 */
	@GetMapping({"/users/{id}", "/users"})
	@ResponseBody
	public Result getUser(@PathVariable(value = "id", required = false) String id) {
		Object obj;
		if (id == null) {
			obj = userService.queryAllUser();
		} else {
			obj = userService.queryUserById(id);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			map.put("users", obj);
			return Result.makeSuccessResult(map);
		} else {
			return Result.makeFailResult("未查找到用户");
		}
	}
}
