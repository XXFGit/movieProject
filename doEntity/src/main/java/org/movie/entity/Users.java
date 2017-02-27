package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/1/8.
 * 用户信息表
 */
@Entity
@Table(name="user_info")
public class Users {
    private int uid;
    private String userTel;


  /*  private Set<Order> order=new HashSet<>(); //一对多关联电影*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="u_id")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Column(name="user_Tel")
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /*@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }*/
}
