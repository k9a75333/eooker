package com.modules.sys.entity;

/**
 * 课室
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class Classroom {
	private String id;

	/**
	 * 地点 例：A5-205
	 */
	private String location;

	/**
	 * 行
	 */
	private String row;

	/**
	 * 列
	 */
	private String column;
	
	/**
	 * 过道位置，从1开始   例如： 5|4|13
	 */
	private String index;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	/**
	 * 是否有瑕疵 0——无 1——有
	 */
	private String isFlaw;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location == null ? null : location.trim();
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row == null ? null : row.trim();
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column == null ? null : column.trim();
	}

	public String getIsFlaw() {
		return isFlaw;
	}

	public void setIsFlaw(String isFlaw) {
		this.isFlaw = isFlaw == null ? null : isFlaw.trim();
	}
}