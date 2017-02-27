import org.junit.Test;
import org.movie.dao.BaseDao;
import org.movie.dao.OrderDao;
import org.movie.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by 熊显付 on 2017/1/10.
 */
public class testDao {
   /*@Test*/
   /*订单表测试*/
    public void test(){
        OrderDao dao=new OrderDao();
        List<Order> list=dao.findList(Order.class);

    }


//    @Test
    /*上架表测试*/
   /* public void releTest(){
        BaseDao dao=new BaseDao();
        List<Release> list=dao.findList(Release.class);
        System.out.println(list.size());
        for (Release rele: list) {
            for (Scree scree: rele.getScree()) {
                System.out.println(rele.getCinema().getCinemaName());
                System.out.println(rele.getMovie().getMovieName());
                System.out.println(rele.getAudit().getAuditName());
                System.out.println(rele.getrTimeStart());
                System.out.println(rele.getrTimeEnd());
                System.out.println(rele.getState());
                System.out.println(scree.getScreePrice());
                System.out.println(scree.getScreeTime());
                System.out.println(scree.getSid());
            }
            System.out.println("------------------------------");
        }
    }*/

    /*movie表测试*/


    public void testMovie(){
        BaseDao dao=new BaseDao();
        List<Movie> list=dao.findList(Movie.class);
        System.out.println(list.size());
        for(Movie movie :list) {
            System.out.println(movie.getMovieName());
            System.out.println(movie.getMovieDirector());
            System.out.println(movie.getMovieState());
            System.out.println(movie.getMovieTimelong());
            System.out.println(movie.getType().getTname());
            System.out.println(movie.getArea().getaArea());
            System.out.println(movie.getYear().getyNiandai());
            System.out.println(movie.getMovieText());
            System.out.println(movie.getRele());
            System.out.println("-------------------------------------------");
        }
    }

    public void addMovie(){
        BaseDao dao=new BaseDao();
        Movie movie=new Movie();
        movie.setMoviePhoto("kkkk.kpg");
        movie.setMovieName("fdsafda");
        movie.setMovieDirector("afdsa");
        movie.setMovieStar("fadsdfad");
        movie.setMovieState("fasdfasd");
        movie.setMovieText("fasdfa");
        movie.setMovieTimelong("gfdghfgh");
        Year year=new Year();
        year.setYid(1);
        movie.setYear(year);
        Area area=new Area();
        area.setAid(1);
        movie.setArea(area);
        Type type=new Type();
        type.setTid(2);
        movie.setType(type);

        Image image=new Image();
        image.setImageName("ppp.jpghhh.jpg");
        image.setMovie(movie);
        movie.setImage(image);
        dao.save(movie);

    }

    /*ciname表测试*/
    public void testCiname(){
        BaseDao dao=new BaseDao();
        List<Cinema> list=dao.findList(Cinema.class);
        System.out.println(list.size());
        for (Cinema cinema: list) {
            System.out.println(cinema.getCinemaName());
            System.out.println(cinema.getCinemaAddr());
            System.out.println(cinema.getCinemaTel());
            System.out.println(cinema.getCinemaPhoto());
        }

    }

    BaseDao dao=new BaseDao();
    @Test
    public void test2(){
//
//        Movie movie=new Movie();
//        movie.setMid(1);
//        Cinema cinema=new Cinema();
//        cinema.setCid(1);
//        Audit audit=new Audit();
//        audit.setAid(1);
//
//        Release r=new Release();
//        r.setMovie(movie);
//        r.setCinema(cinema);
//        r.setAudit(audit);
//        r.setrTimeEnd(new Date());
//        r.setrTimeStart(new Date());
//        r.setState("uuuuuuuu");

        Release r=new Release();
        r.setRid(2);
        Scree scree=new Scree();


        dao.save(scree);



    }
}
