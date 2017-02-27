package org.movie.entity;

import javax.persistence.*;

/**
 * Created by 熊显付 on 2017/1/8.
 * 评价信息表
 */
@Entity
@Table(name="eval_info")
public class Eval {
    private  int eid;
    private String evalTime; //评价时间
    private String evalText;  //评价内容
    private Users users;   //评价的用户
    //多对一g关联用户

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="e_id")
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Column(name="eval_Time")
    public String getEvalTime() {
        return evalTime;
    }

    public void setEvalTime(String evalTime) {
        this.evalTime = evalTime;
    }

    @Column(name="eval_Text")
    public String getEvalText() {
        return evalText;
    }

    public void setEvalText(String evalText) {
        this.evalText = evalText;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
