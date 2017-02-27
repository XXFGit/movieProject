package org.movie.dao;

import org.movie.entity.Type;
import org.movie.utils.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Created by 熊显付 on 2017/2/12.
 */
public class TypeDao  extends  BaseDao<Type>{
    public Boolean delete2(Type type){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Boolean flag=true;
        try{
            em.remove(em.merge(type));
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
