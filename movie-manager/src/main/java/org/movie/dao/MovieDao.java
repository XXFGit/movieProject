package org.movie.dao;

import org.movie.entity.Movie;
import org.movie.utils.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Created by 熊显付 on 2017/1/11.
 */
public class MovieDao extends BaseDao<Movie> {
    public Boolean delete2(Movie movie){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Boolean flag=true;
        try{
            em.remove(em.merge(movie));
            em.getTransaction().commit();
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            flag=false;
        }finally{
            em.close();
        }
        return flag;
    }
}

