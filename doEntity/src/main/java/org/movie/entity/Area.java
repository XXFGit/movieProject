package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/2/11.
 */
@Entity
@Table(name="area_info")
public class Area {
    private int aid;
    private String aArea;
    private Set<Movie> movie=new HashSet<>();  //一对多关联电影

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="a_id")
    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
    @Column(name="areaName")
    public String getaArea() {
        return aArea;
    }
    public void setaArea(String aArea) {
        this.aArea = aArea;
    }

    @OneToMany(fetch= FetchType.EAGER, mappedBy="area")
    public Set<Movie> getMovie() {
        return movie;
    }
    public void setMovie(Set<Movie> movie) {
        this.movie = movie;
    }
}
