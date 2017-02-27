package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/1/8.
 * 电影院信息表
 */
@Entity
@Table(name="cinema_info")
public class Cinema {
    private int  cid;
    private String cinemaName;  //电影院名称
    private String cinemaAddr;  //电影院地址
    private String cinemaTel;  //电影院电话
    private String cinemaPhoto; //电影院图片
    private String cinemaText;  //电影院简介
    //一对多关联上架信息
    private Set<Release> rele=new HashSet<>();
    //一对多关联影厅
    private Set<Audit> audit=new HashSet<>();

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="c_id")
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }

    @Column(name="cinema_Name")
    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    @Column(name="cinema_Addr")
    public String getCinemaAddr() {
        return cinemaAddr;
    }

    public void setCinemaAddr(String cinemaAddr) {
        this.cinemaAddr = cinemaAddr;
    }

    @Column(name="cinema_Tel")
    public String getCinemaTel() {
        return cinemaTel;
    }

    public void setCinemaTel(String cinemaTel) {
        this.cinemaTel = cinemaTel;
    }
    @Column(name="cinema_Photo")
    public String getCinemaPhoto() {
        return cinemaPhoto;
    }

    public void setCinemaPhoto(String cinemaPhoto) {
        this.cinemaPhoto = cinemaPhoto;
    }
    @Column(name="cinema_Text")
    public String getCinemaText() {
        return cinemaText;
    }

    @Column(name="cinema_Text")
    public void setCinemaText(String cinemaText) {
        this.cinemaText = cinemaText;
    }


    //一堆多关联影厅
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cinema")
    public Set<Audit> getAudit() {
        return audit;
    }
    public void setAudit(Set<Audit> audit) {
        this.audit = audit;
    }

    //一对多关联上架
    @OneToMany(fetch=FetchType.EAGER, mappedBy="cinema")
    public Set<Release> getRele() {
        return rele;
    }
    public void setRele(Set<Release> rele) {
        this.rele = rele;
    }
}
