package com.modules.sys.entity;

/**
 * 
 * @author LiuYu
 * 
 * @date 2018-10-27
 */
public class SysRolePrivilege {
    private String roleId;

    private String privilegeId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId == null ? null : privilegeId.trim();
    }
}