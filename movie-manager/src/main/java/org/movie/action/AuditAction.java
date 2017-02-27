package org.movie.action;

import org.movie.dao.AuditDao;
import org.movie.entity.Audit;
import org.movie.entity.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊显付 on 2017/2/23.
 */
public class AuditAction {
    private Audit audit;
    private List<Audit> list=new ArrayList<>();
    private int ID;
    private String massage;

    public Audit getAudit() {
        return audit;
    }
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
    public List<Audit> getList() {
        return list;
    }
    public void setList(List<Audit> list) {
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

    AuditDao dao=new AuditDao();
    public String all(){
        list=dao.findList(Audit.class);
        System.out.println(list.size());
        return "allAudit";
    }

    public String del(){
        System.out.println(ID);
        Audit audit=new Audit();
        audit.setAid(ID);
        Boolean flag=dao.delete2(audit);
        if(flag==true){massage="删除成功！";}else{massage="删除失败！";}
        return "delAudit";
    }

    public String add(){
        Boolean flag=dao.save(audit);
        if(flag==true){massage="添加成功！";}else{ massage="添加失败！";}
        return "addAudit";
    }

    public String ById(){
        audit=dao.findById(Audit.class,ID);
        return "ByIdAudit";
    }

    public String update(){
        dao.update(audit);
        massage="修改成功!";
        return "updateAudit";
    }
}
