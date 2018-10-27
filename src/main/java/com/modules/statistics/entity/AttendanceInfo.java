package com.modules.statistics.entity;

/**
 * 学生具体的位置信息以及考勤情况
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class AttendanceInfo {
    private String id;

    private String stuId;

    private String mapId;

    private String x;

    private String y;

    /**
     * 是否被验证
0：未验证
1：已验证
     */
    private String isAttend;

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

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId == null ? null : mapId.trim();
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x == null ? null : x.trim();
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y == null ? null : y.trim();
    }

    public String getIsAttend() {
        return isAttend;
    }

    public void setIsAttend(String isAttend) {
        this.isAttend = isAttend == null ? null : isAttend.trim();
    }
}