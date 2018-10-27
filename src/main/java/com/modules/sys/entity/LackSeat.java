package com.modules.sys.entity;

/**
 * 
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class LackSeat {
    private String id;

    private String row;

    private String lIndex;

    private String rIndex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row == null ? null : row.trim();
    }

    public String getlIndex() {
        return lIndex;
    }

    public void setlIndex(String lIndex) {
        this.lIndex = lIndex == null ? null : lIndex.trim();
    }

    public String getrIndex() {
        return rIndex;
    }

    public void setrIndex(String rIndex) {
        this.rIndex = rIndex == null ? null : rIndex.trim();
    }
}