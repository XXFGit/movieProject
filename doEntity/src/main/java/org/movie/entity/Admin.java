package org.movie.entity;

import javax.persistence.*;

/**
 * Created by 熊显付 on 2017/1/8.
 * 管理员表
 */
@Entity
@Table(name="admin_info")
public class Admin {
    private int id;
    private String adminName;
    private String adminPwd;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    @Column(name="admin_Name")
    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    @Column(name="admin_Pwd")
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }
}
