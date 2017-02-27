package org.movie.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.movie.dao.MovieDao;
import org.movie.entity.Movie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊显付 on 2017/2/12.
 */

public class MovieAction extends ActionSupport{
    private Movie movie;
    private int ID;
    private String massage;
    List<Movie> list=new ArrayList<>();

    private File uploadFile;
    //上传的文件名,格式必须是File名称 + FileName
    private String uploadFileFileName;
    //上传的文件类型,格式必须是File名称 + ContentType
    private String uploadFileContentType;

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public List<Movie> getList() {
        return list;
    }
    public void setList(List<Movie> list) {
        this.list = list;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public String getMassage() {
        return massage;
    }
    public void setMassage(String massage) {
        this.massage = massage;
    }
    public File getUploadFile() {
        return uploadFile;
    }
    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }
    public String getUploadFileFileName() {
        return uploadFileFileName;
    }
    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }
    public String getUploadFileContentType() {
        return uploadFileContentType;
    }
    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    MovieDao dao=new MovieDao();

    public String upload() throws IOException {
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/files");
        if(uploadFile != null){
            //根据文件名以及上传的路径构建一个新的File对象
            System.out.println(uploadPath);
            File saveFile = new File(uploadPath, uploadFileFileName);
            //先判断上传的目录是否存在，如果不存在则创建出来
            if(!saveFile.getParentFile().exists()){
                saveFile.getParentFile().mkdirs();
            }
            //使用文件复制执行上传
            FileUtils.copyFile(uploadFile, saveFile);
            //提示成功信息
            massage = uploadFileFileName;
            //将图片文件名保存到上下文作用域中
            ActionContext.getContext().getApplication().put("w",uploadFileFileName);
        }
        return "uploadImage";
    }

    public String add(){
        movie.setMoviePhoto((String) ActionContext.getContext().getApplication().get("w"));
        Boolean flag=dao.save(movie);
        if(flag==true){massage="添加成功！";}else{ massage="添加失败！";}
        return "add";
    }

    public String all(){
        list=dao.findList(Movie.class);
        System.out.println(list.size());
        return "allMovie";
    }
    public String del(){
        System.out.println(ID);
        Movie movie=new Movie();
        movie.setMid(ID);
        Boolean flag=dao.delete2(movie);
        if(flag==true){massage="删除成功！";}else{massage="删除失败！";}
        return "del";
    }

    public String ById(){
        movie=dao.findById(Movie.class,ID);
        System.out.println(movie.toString());
        return "ByIdMovie";
    }

    public String update(){
        movie.setMoviePhoto((String) ActionContext.getContext().getApplication().get("w"));
        System.out.println(ActionContext.getContext().getApplication().get("w"));
        System.out.println(movie);
        dao.update(movie);
        massage="修改成功";
        return "updateMovie";
    }
}
