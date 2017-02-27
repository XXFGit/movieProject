package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/1/8.
 影厅信息表
 */
@Entity
@Table(name="audit_info")
public class Audit {
    private int aid; //id
    private String auditName; //影厅名称
    private  int auditNum;   //影厅总座位数
    private String auditText;  //影厅简介
    //多对一关联电影院
    private Cinema cinema;
    //一对多关联上架信息
    private Set<Release> rele=new HashSet<>();
    //一对多关联场次
    private Set<Scree> scree=new HashSet<>();
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="a_id")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
    @Column(name="audit_Name")
    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }
    @Column(name="audit_Num")
    public int getAuditNum() {
        return auditNum;
    }

    public void setAuditNum(int auditNum) {
        this.auditNum = auditNum;
    }
    @Column(name="audit_Text")
    public String getAuditText() {
        return auditText;
    }

    public void setAuditText(String auditText) {
        this.auditText = auditText;
    }

    @ManyToOne
    @JoinColumn(name = "ciname_id")
    public Cinema getCinema() {
        return cinema;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }


    @OneToMany(fetch=FetchType.EAGER,mappedBy ="audit")
    public Set<Release> getRele() {
        return rele;
    }
    public void setRele(Set<Release> rele) {
        this.rele = rele;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="audit")
    public Set<Scree> getScree() {
        return scree;
    }

    public void setScree(Set<Scree> scree) {
        this.scree = scree;
    }
}
