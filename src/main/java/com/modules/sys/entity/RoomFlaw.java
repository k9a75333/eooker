package com.modules.sys.entity;

/**
 * 课室布局不是矩形的课室
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class RoomFlaw {
    private String id;

    private String roomId;

    private String lackSeatId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getLackSeatId() {
        return lackSeatId;
    }

    public void setLackSeatId(String lackSeatId) {
        this.lackSeatId = lackSeatId == null ? null : lackSeatId.trim();
    }
}