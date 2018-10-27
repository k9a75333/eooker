package com.modules.sys.entity;

/**
 * 用来指示教室过道的位置

 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class Aisle {
    private String id;

    private String roomId;

    /**
     * 指示过道的位置
     */
    private String index;

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

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index == null ? null : index.trim();
    }
}