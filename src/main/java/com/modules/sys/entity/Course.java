package com.modules.sys.entity;

/**
 * 课程表
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class Course {
	private String id;

	/**
	 * 课程名
	 */
	private String name;

	/**
	 * 课程的持续时间 例如：1-6,8-10 注意：以逗号分隔
	 */
	private String duration;

	/**
	 * 学分
	 */
	private String credit;

	/**
	 * 课程属性——例如必修课
	 */
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration == null ? null : duration.trim();
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit == null ? null : credit.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
}