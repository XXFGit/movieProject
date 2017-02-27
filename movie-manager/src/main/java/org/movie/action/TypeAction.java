package org.movie.action;

import org.movie.dao.TypeDao;
import org.movie.entity.Movie;
import org.movie.entity.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊显付 on 2017/2/12.
 */
public class TypeAction {
    private Type type;

    private List<Type> list=new ArrayList<>();
    private int ID;
    private String massage;
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public List<Type> getList() {
        return list;
    }
    public void setList(List<Type> list) {
        this.list = list;
    }
    public String getMassage() {
        return massage;
    }
    public void setMassage(String massage) {
        this.massage = massage;
    }

    TypeDao dao=new TypeDao();
    public String all(){
        list=dao.findList(Type.class);
        System.out.println(list.size());
        return "allType";
    }

    public String del(){
        System.out.println(ID);
        Type type=new Type();
        type.setTid(ID);
        Boolean flag=dao.delete2(type);
        if(flag==true){massage="删除成功！";}else{massage="删除失败！";}
        return "delType";
    }

    public String add(){
        Boolean flag=dao.save(type);
        if(flag==true){massage="添加成功！";}else{ massage="添加失败！";}
        return "addType";
    }

    public String ById(){
        type=dao.findById(Type.class,ID);
        return "ByIdType";
    }

    public String update(){
        dao.update(type);
        System.out.println("fagfsh");
        massage="修改成功!";
        return "updateType";
    }
}
