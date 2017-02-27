package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/1/8.
 * 电影种类
 */
@Entity
@Table(name="type_info")
public class Type {
    private int tid;
    private String tname; //种类名称
    private Set<Movie> type=new HashSet<>(); //一对多关联电影


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="t_id")
    public int getTid() {
        return tid;
    }
    public void setTid(int tid) {
        this.tid = tid;
    }

    @Column(name="type_Name")

    public String getTname() {
        return tname;
    }
    public void setTname(String tname) {
        this.tname = tname;
    }
    @OneToMany(fetch=FetchType.EAGER, mappedBy="type")
    public Set<Movie> getType() {
        return type;
    }
    public void setType(Set<Movie> type) {
        this.type = type;
    }

}
