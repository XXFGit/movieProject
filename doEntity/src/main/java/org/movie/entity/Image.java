package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/2/14.
 */
@Entity
@Table(name="image_info")
public class Image {
    private int Imgid;
    private String imageName;
    private Movie movie;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="image_id")
    public int getImgid() {
        return Imgid;
    }
    public void setImgid(int imgid) {
        Imgid = imgid;
    }
    @Column(name="image_name")
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @OneToOne
    @JoinColumn(name="movie_id")
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
