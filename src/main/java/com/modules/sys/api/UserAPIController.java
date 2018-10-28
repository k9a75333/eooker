package com.modules.sys.api;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.common.server.WebSocketServer;
import com.common.utils.IdGen;
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
@RestController
@RequestMapping("${adminPath}/sys/userAPI")
public class UserAPIController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	StringRedisTemplate template;
 	
	@RequestMapping("testWebSocket")
	public String testWebSocket(@RequestParam(value = "num", required = true) int num) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < num ; i++) {
					WebSocketServer.sendMessageTodigits("201610097027", i + "啦啦啦啦啦啦");
					System.err.println("发送成功:" + "201610097027" + i + "啦啦啦啦啦啦");
				}
			}
		});
		thread.start();
		return "success";
	}
	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	@PostMapping("/users")
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
	
	/**
	 * 登录接口
	 * @param digits 学号
	 * @param password 密码
	 * @return
	 */
	@GetMapping("/login/{digits}/{password}")
	public Result login(
			@PathVariable String digits, 
			@PathVariable String password) {
		User user = userService.login(digits, password); 
		if (user == null) {
			return Result.makeFailResult("failed");
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("is_tutor", user.getIsTutor());
			template.opsForValue().set(digits, IdGen.uuid());
			return Result.makeSuccessResult(map);
		}
	}
	
	/**
	 * 获取所有课程信息
	 * @return
	 */
	@GetMapping("/course")
	public Result getCourseAllInfo() {
		List<String> coursesName = userService.getCourseAllInfo();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courses", coursesName);
		return Result.makeSuccessResult(map);
	}
	
	/**
	 * 生成房间号
	 * @return
	 */
	@GetMapping("/room_number")
	public Result GenerateRoomNumber() {
		DecimalFormat df = new DecimalFormat("000000");
		Random random = new Random();
		String roomNumber = df.format(random.nextInt(999999));
		System.err.println(roomNumber);
		Map<String, String> innerMap = new HashMap<String,String>();
		innerMap.put("time", "3");
		template.opsForHash().putAll(roomNumber, innerMap);
//		String s = (String) template.opsForHash().get(roomNumber, "time");
//		System.err.println(s);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roomNumber", roomNumber);
		return Result.makeSuccessResult(map);
	}
	
	/**
	 * 验证房间号是否存在
	 * 0——不存在   1——存在
	 * @return
	 */
	@GetMapping("verification/{roomNumber}")
	public Result verification(@PathVariable String roomNumber) {
		String s = (String) template.opsForHash().get(roomNumber, "time");
		if (s == null) {
			return Result.makeFailResult("0");
		}
		return Result.makeSuccessResult("1");
	}
	
	@GetMapping({"classroom", "classroom/{location}"})
	public Result getAllClassroomName(@PathVariable(value = "location", required = false) String location) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (location == null) {
			List<String> classroomName = userService.getAllClassroomName();
			map.put("classroomLocation", classroomName);
		} else {
			Map<String, Object> infoMap = userService.getSpecificRoomInfo(location);
			map.put("specific_room_info", infoMap);
		}
		return Result.makeSuccessResult(map);
	}
	
 }
