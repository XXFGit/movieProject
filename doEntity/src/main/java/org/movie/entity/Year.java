package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/2/11.
 */
@Entity
@Table(name="year_info")
public class Year {
    private int yid;
    private String yNiandai;
    private Set<Movie> movie=new HashSet<>();  //一对多关联电影

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="y_id")
    public int getYid() {
        return yid;
    }
    public void setYid(int yid) {
        this.yid = yid;
    }

    @Column(name="yearName")
    public String getyNiandai() {
        return yNiandai;
    }
    public void setyNiandai(String yNiandai) {
        this.yNiandai = yNiandai;
    }

    @OneToMany(fetch= FetchType.EAGER, mappedBy="year")
    public Set<Movie> getMovie() {
        return movie;
    }
    public void setMovie(Set<Movie> movie) {
        this.movie = movie;
    }
}
