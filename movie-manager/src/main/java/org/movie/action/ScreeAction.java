package org.movie.action;

import org.movie.dao.ScreeDao;
import org.movie.entity.Audit;
import org.movie.entity.Scree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊显付 on 2017/2/23.
 */
public class ScreeAction {
    private Scree scree;
    private List<Scree> list=new ArrayList<>();
    private int ID;
    private String massage;

    public Scree getScree() {
        return scree;
    }
    public void setScree(Scree scree) {
        this.scree = scree;
    }
    public List<Scree> getList() {
        return list;
    }
    public void setList(List<Scree> list) {
        this.list = list;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getMassage() {
        return massage;
    }
    public void setMassage(String massage) {
        this.massage = massage;
    }

    ScreeDao dao=new ScreeDao();
    public String all(){
        list=dao.findList(Scree.class);
        System.out.println(list.size());
        return "allScree";
    }

    public String del(){
        System.out.println(ID);
        Scree scree=new Scree();
        scree.setSid(ID);
        Boolean flag=dao.delete2(scree);
        if(flag==true){massage="删除成功！";}else{massage="删除失败！";}
        return "delScree";
    }

    public String add(){
        Boolean flag=dao.save(scree);
        if(flag==true){massage="添加成功！";}else{ massage="添加失败！";}
        return "addScree";
    }

    public String ById(){
        scree=dao.findById(Scree.class,ID);
        return "ByIdScree";
    }

    public String update(){
        dao.update(scree);
        massage="修改成功!";
        return "updateScree";
    }
}
