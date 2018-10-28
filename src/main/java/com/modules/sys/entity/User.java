package com.modules.sys.entity;

import java.util.Date;

/**
 * 用户表
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class User {
    private String id;

    /**
     * 姓名
     */
    private String name;

    private String password;

    /**
     * 性别 0——男  1——女
     */
    private String sex;

    /**
     * 生日
     */
    private String birth;
    
    /**
     * 学号或工号
     */
    private String digits;

    /**
     * 身份证号码
     */
    private String idCardNo;

    /**
     * 班级序号
     */
    private String sequence;

    /**
     * 班级
     */
    private String belongClass;

    /**
     * 学院或部门
     */
    private String department;
    
    /**
     * 专业
     */
    private String major;
    
    /**
     * 专业方向
     */
    private String major_filed;
    
    /**
     * 年级
     */
    private String grade;
    
    /**
     * 是否是老师 0——不是  1——是
     */
    private String isTutor;

    public String getIsTutor() {
		return isTutor;
	}

	public void setIsTutor(String isTutor) {
		this.isTutor = isTutor;
	}

	/**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记 0-代表未删除 1-代表已删除
     */
    private String delFlag;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits == null ? null : digits.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }

    public String getBelongClass() {
        return belongClass;
    }

    public void setTeam(String belongClass) {
        this.belongClass = belongClass == null ? null : belongClass.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajor_filed() {
		return major_filed;
	}

	public void setMajor_filed(String major_filed) {
		this.major_filed = major_filed;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setBelongClass(String belongClass) {
		this.belongClass = belongClass;
	}
}