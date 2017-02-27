package org.movie.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/1/10.
 * 场次信息表
 */
@Entity
@Table(name="scree_info")
public class Scree {
    private int sid;
    private Date screeTime;
    private double screePrice;
    private Audit audit;
    private Set<Release> rele=new HashSet<>();

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="s_id")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Column(name="scree_Time")
    public Date getScreeTime() {
        return screeTime;
    }

    public void setScreeTime(Date screeTime) {
        this.screeTime = screeTime;
    }

    @Column(name="scree_Price")
    public double getScreePrice() {
        return screePrice;
    }

    public void setScreePrice(double screePrice) {
        this.screePrice = screePrice;
    }

    @ManyToOne
    @JoinColumn(name = "audit_id")
    public Audit getAudit() {
        return audit;
    }
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @OneToMany(fetch=FetchType.EAGER,mappedBy ="scree")
    public Set<Release> getRele() {
        return rele;
    }
    public void setRele(Set<Release> rele) {
        this.rele = rele;
    }
}
