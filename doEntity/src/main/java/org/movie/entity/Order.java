package org.movie.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 熊显付 on 2017/1/9.
 * 订单信息表
 */
@Entity
@Table(name="order_info")
public class Order {
    private int oid;
    private String orderNumber; //订单号
    private int orderNum;  //数量
    private double orderMenoy; //总金额
    private Date orderTime; //订单生成时间
    private String orderPay; //支付方式
    private Movie movie;  //一对多关联电影
    private Users users;  //多对一关联用户

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="o_id")
    public int getOid() {
        return oid;
    }
    public void setOid(int oid) {
        this.oid = oid;
    }
    @Column(name="order_Number")
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    @Column(name="order_Num")
    public int getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
   @Column(name="order_Menoy")
    public double getOrderMenoy() {
        return orderMenoy;
    }
    public void setOrderMenoy(double orderMenoy) {
        this.orderMenoy = orderMenoy;
    }
    @Column(name="order_Time")
    public Date getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
    @Column(name="order_Pay")
    public String getOrderPay() {
        return orderPay;
    }
    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }

    @ManyToOne
    @JoinColumn(name = "movie_id")
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne
    @JoinColumn(name = "users_id")
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
}
