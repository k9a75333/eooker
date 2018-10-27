package com.modules.statistics.entity;

/**
 * 最终生成的签到座位表（已验证）统计信息
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class SeatMapInfo {
    private String id;

    private String courseDetailId;

    /**
     * 所有人数
     */
    private String total;

    /**
     * 缺勤人数
     */
    private String absenceNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(String courseDetailId) {
        this.courseDetailId = courseDetailId == null ? null : courseDetailId.trim();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public String getAbsenceNum() {
        return absenceNum;
    }

    public void setAbsenceNum(String absenceNum) {
        this.absenceNum = absenceNum == null ? null : absenceNum.trim();
    }
}