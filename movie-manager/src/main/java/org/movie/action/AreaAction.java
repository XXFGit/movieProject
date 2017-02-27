package org.movie.action;

import org.movie.dao.AreaDao;
import org.movie.entity.Area;
import org.movie.entity.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊显付 on 2017/2/12.
 */
public class AreaAction {
    private Area area;
    private int ID;
    private List<Area> list=new ArrayList<>();
    private String massage;

    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public List<Area> getList() {
        return list;
    }
    public void setList(List<Area> list) {
        this.list = list;
    }
    public String getMassage() {
        return massage;
    }
    public void setMassage(String massage) {
        this.massage = massage;
    }

    AreaDao dao=new AreaDao();

    public String all() {
    list=dao.findList(Area.class);
    return "allArea";
    }

    public String del(){
        Area area=new Area();
        area.setAid(ID);
        Boolean flag=dao.delete2(area);
        if(flag==true){massage="删除成功！";}else{massage="删除失败！";}
        return "delArea";
    }

    public String add(){
        Boolean flag=dao.save(area);
        if(flag==true){massage="添加成功！";}else{ massage="添加失败！";}
        return "addArea";
    }

    public String ById(){
        area=dao.findById(Area.class,ID);
        return "ByIdArea";
    }

    public String update(){
        dao.update(area);
        massage="修改成功!";
        return "updateArea";
    }
}
