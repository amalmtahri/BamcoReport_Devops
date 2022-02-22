package com.application.bamcoreport.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_memberships")
public class UserMemberShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name="userid", referencedColumnName = "id")
    private User userid;


    @ManyToOne()
    @JoinColumn(name="roleid", referencedColumnName = "id")
    private Role roleid;

    @ManyToOne()
    @JoinColumn(name="groupid", referencedColumnName = "id")
    private Group groupid;

    @ManyToOne()
    @JoinColumn(name="assignedby", referencedColumnName = "id")
    private User assignedby;

    @CreatedDate
    @Column(name = "assigneddate", nullable = false)
    private Date assigneddate;

    public UserMemberShip() {
    }

    public UserMemberShip(long id, User userid, Role roleid, Group groupid, User assignedby, Date assigneddate) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
        this.groupid = groupid;
        this.assignedby = assignedby;
        this.assigneddate = assigneddate;
    }

    public UserMemberShip( User userid, Role roleid, Group groupid, User assignedby, Date assigneddate) {
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
        return this.userid;
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
        return "UserMemberShip{" +
                "id=" + id +
                ", userid=" + userid +
                ", roleid=" + roleid +
                ", groupid=" + groupid +
                ", assignedby=" + assignedby +
                ", assigneddate=" + assigneddate +
                '}';
    }
}
