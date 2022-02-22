package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;

import java.util.Date;

public class UserMemberShipDto {


    private long id;
    private User userid;
    private Role roleid;
    private Group groupid;
    private User assignedby;
    private Date assigneddate;

    public UserMemberShipDto() {
    }

    public UserMemberShipDto(long id, User userid, Role roleid, Group groupid, User assignedby, Date assigneddate) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
        this.groupid = groupid;
        this.assignedby = assignedby;
        this.assigneddate = assigneddate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    public Group getGroupid() {
        return groupid;
    }

    public void setGroupid(Group groupid) {
        this.groupid = groupid;
    }

    public User getAssignedby() {
        return assignedby;
    }

    public void setAssignedby(User assignedby) {
        this.assignedby = assignedby;
    }

    public Date getAssigneddate() {
        return assigneddate;
    }

    public void setAssigneddate(Date assigneddate) {
        this.assigneddate = assigneddate;
    }

    @Override
    public String toString() {
        return "UserMemberShipDto{" +
                "id=" + id +
                ", userid=" + userid +
                ", roleid=" + roleid +
                ", groupid=" + groupid +
                ", assignedby=" + assignedby +
                ", assigneddate=" + assigneddate +
                '}';
    }
}
