package com.modules.sys.entity;

/**
 * 课程的详细信息
 * 
 * @author wcyong
 * 
 * @date 2018-10-27
 */
public class CourseDetail {
    private String id;

    private String courseId;

    private String roomId;

    private String tutorId;

    /**
     * 第几周
     */
    private String week;

    /**
     * 星期几
     */
    private String day;

    /**
     * 持续时间  ，例如——2节
     */
    private String duration;

    /**
     * 第几节课

     */
    private String sequence;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId == null ? null : tutorId.trim();
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }
}