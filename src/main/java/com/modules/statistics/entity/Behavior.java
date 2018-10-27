package com.modules.statistics.entity;

/**
 * 行为信息记录表  xy代表主动扫的那个人，x1 y1代表被扫的人
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class Behavior {
    private String id;

    private String initiativeStuId;

    private String passivityStuId;

    private String courseDetailId;

    /**
     * 例如  1,2-3,4
     */
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInitiativeStuId() {
        return initiativeStuId;
    }

    public void setInitiativeStuId(String initiativeStuId) {
        this.initiativeStuId = initiativeStuId == null ? null : initiativeStuId.trim();
    }

    public String getPassivityStuId() {
        return passivityStuId;
    }

    public void setPassivityStuId(String passivityStuId) {
        this.passivityStuId = passivityStuId == null ? null : passivityStuId.trim();
    }

    public String getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(String courseDetailId) {
        this.courseDetailId = courseDetailId == null ? null : courseDetailId.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }
}