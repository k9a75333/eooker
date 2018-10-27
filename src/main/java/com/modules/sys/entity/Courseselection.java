package com.modules.sys.entity;

/**
 * 学生选课表
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class Courseselection {
    private String id;

    /**
     * 学生id
     */
    private String stuId;

    /**
     * 课程id

     */
    private String courseId;

    /**
     * 学年——例如 2016
     */
    private String year;

    /**
     * 学期——例如 1 | 2

     */
    private String semester;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }
}