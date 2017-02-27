package org.movie.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/1/8.
 * 上架信息表
 */
@Entity
@Table(name="rele_info")
public class Release {
    private int rid;
    private Date rTimeStart; //上映时间
    private Date rTimeEnd;  //下映时间
    private String state;   //状态
    //多对一关联电影院
    private Cinema cinema;
    //多对一关联电影
    private Movie movie;
    //多对一关联影厅
   private Audit audit;
    //一对多关联场次
   /* private Set<Scree> scree=new HashSet<>();*/
    private Scree scree;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="r_id")

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
    @Column(name="rele_rTimeStart")
    public Date getrTimeStart() {
        return rTimeStart;
    }

    public void setrTimeStart(Date rTimeStart) {
        this.rTimeStart = rTimeStart;
    }
    @Column(name="rele_rTimeEnd")
    public Date getrTimeEnd() {
        return rTimeEnd;
    }

    public void setrTimeEnd(Date rTimeEnd) {
        this.rTimeEnd = rTimeEnd;
    }
    @Column(name="rele_rTimeState")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //多对一关联电影院
    @ManyToOne
    @JoinColumn(name="cinema_id")
    public Cinema getCinema() {
        return cinema;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    //多对一关联电影
    @ManyToOne
    @JoinColumn(name="movie_id")
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    //多对一关联影厅
    @ManyToOne
    @JoinColumn(name="audit_id")
    public Audit getAudit() {
        return audit;
    }
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    //一对多关联场次
    @ManyToOne
    @JoinColumn(name = "scree_id")
    public Scree getScree() {
        return scree;
    }
    public void setScree(Scree scree) {
        this.scree = scree;
    }
}
