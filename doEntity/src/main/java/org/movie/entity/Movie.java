package org.movie.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 熊显付 on 2017/1/8.
 * 电影信息表
 */
@Entity
@Table(name="movie_info")
public class Movie {
    private int mid;
    private String movieName; //电影名称
    private String movieTimelong; //电影时长
    private Type type;  //电影类型
    private String moviePhoto;  //电影图片
    private String movieDirector; //导演
    private String movieStar;  //主演
    private String movieText; //简介
    private String movieState; //状态
    private Set<Release> rele=new HashSet<>(); //一对多关联上架信息表
    private Area area;  //多对一关联地区
    private Image image;
    private Year year;
    private Set<Order> order=new HashSet<>();//一对多关联订单表


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="m_id")
    public int getMid() {
        return mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
    }
    @Column(name="movie_Name")
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    @Column(name="movie_Timelong")
    public String getMovieTimelong() {
        return movieTimelong;
    }
    public void setMovieTimelong(String movieTimelong) {
        this.movieTimelong = movieTimelong;
    }
    @Column(name="movie_Photo")
    public String getMoviePhoto() {
        return moviePhoto;
    }
    public void setMoviePhoto(String moviePhoto) {
        this.moviePhoto = moviePhoto;
    }
    @Column(name="movie_Director")
    public String getMovieDirector() {
        return movieDirector;
    }
    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }
    @Column(name="movie_Star")
    public String getMovieStar() {
        return movieStar;
    }
    public void setMovieStar(String movieStar) {
        this.movieStar = movieStar;
    }
    @Column(name="movie_Text")
    public String getMovieText() {
        return movieText;
    }
    public void setMovieText(String movieText) {
        this.movieText = movieText;
    }
    @Column(name="movie_State")
    public String getMovieState() {
        return movieState;
    }
    public void setMovieState(String movieState) {
        this.movieState = movieState;
    }

    //多对一种类
    @ManyToOne
    @JoinColumn(name = "type_id")
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    //多对一关联地区
    @ManyToOne
    @JoinColumn(name = "area_id")
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }

    //多对一关联年代
    @ManyToOne
    @JoinColumn(name = "year_id")
    public Year getYear() {
        return year;
    }
    public void setYear(Year year) {
        this.year = year;
    }

    //一对多关联上架
    @OneToMany(fetch=FetchType.EAGER,mappedBy ="movie")
    public Set<Release> getRele() {
        return rele;
    }
    public void setRele(Set<Release> rele) {
        this.rele = rele;
    }

    @OneToOne(cascade={CascadeType.PERSIST,
            CascadeType.REMOVE,CascadeType.MERGE},
            mappedBy="movie")
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    @OneToMany(fetch=FetchType.EAGER,mappedBy ="movie")
    public Set<Order> getOrder() {
        return order;
    }
    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mid=" + mid +
                ", movieName='" + movieName + '\'' +
                ", movieTimelong='" + movieTimelong + '\'' +
                ", type=" + type +
                ", moviePhoto='" + moviePhoto + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieStar='" + movieStar + '\'' +
                ", movieText='" + movieText + '\'' +
                ", movieState='" + movieState + '\'' +
                ", rele=" + rele +
                ", area=" + area +
                ", year=" + year +
                '}';
    }
}
