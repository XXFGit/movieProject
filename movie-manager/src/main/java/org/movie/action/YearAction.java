package org.movie.action;

import org.movie.dao.YearDao;
import org.movie.entity.Area;
import org.movie.entity.Year;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊显付 on 2017/2/12.
 */
public class YearAction {
    private Year year;
    private int ID;
    private String massage;

    private List<Year> list=new ArrayList<>();
    public Year getYear() {
        return year;
    }
    public void setYear(Year year) {
        this.year = year;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getMessage() {
        return massage;
    }
    public void setMessage(String message) {
        this.massage = message;
    }
    public List<Year> getList() {
        return list;
    }
    public void setList(List<Year> list) {
        this.list = list;
    }

    YearDao dao=new YearDao();
    public String all(){
        list=dao.findList(Year.class);
        return "allYear";
    }

    public String del(){
        Year year=new Year();
        year.setYid(ID);
        Boolean flag=dao.delete2(year);
        if(flag==true){massage="删除成功！";}else{massage="删除失败！";}
        return "delYear";
    }

    public String add(){
        Boolean flag=dao.save(year);
        if(flag==true){massage="添加成功！";}else{ massage="添加失败！";}
        return "addYear";
    }

    public String ById(){
        year=dao.findById(Year.class,ID);
        return "ByIdYear";
    }

    public String update(){
        dao.update(year);
        massage="修改成功!";
        return "updateYear";
    }
}
