package org.movie.dao;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.movie.entity.Type;
import org.movie.utils.HibernateUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class BaseDao<T> {	
		public Boolean save(T t){
			EntityManager em= HibernateUtil.getEntityManager();
			em.getTransaction().begin();
			Boolean flag=false;
			try {
				em.persist(t);
				em.getTransaction().commit();
				flag=true;
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
				flag=false;
			}finally {
				em.close();
			}
			return flag;
		}
		
		public Boolean delete(T t){
			EntityManager em=HibernateUtil.getEntityManager();
			em.getTransaction().begin();
			Boolean flag=false;
			try {
				em.remove(t);
				em.getTransaction().commit();
				flag=true;
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
				flag=false;
			}finally {
				em.close();
			}
			return flag;
		}

	public Boolean delete2(T t){
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		Boolean flag=true;
		try{
			em.remove(em.merge(t));
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


		public void update(T t){
			EntityManager em=HibernateUtil.getEntityManager();
			em.getTransaction().begin();
			try {
				em.merge(t);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			}finally {
				em.close();
			}
		}

		
		
		public T findById(Class<T> entityClass,Object id){
			EntityManager em=HibernateUtil.getEntityManager();
			em.getTransaction().begin();
			T entity=null;
			try {
				entity=em.find(entityClass, id);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			}finally {
				em.close();
			}
			return entity;
		}



	public List<T> findList(Class<T> entityClass){
		String jpql="from "+entityClass.getName();
		EntityManager em=HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		List<T> list=null;
		try {
			Query query = em.createQuery( jpql,entityClass );
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return list;
	}

	public List<T> queryList2( String jpql, Class<?> clazzEntity ) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		List<T> list = null;
		try {
			Query query = em.createQuery( jpql, clazzEntity );
			list = ( List<T> )query.getResultList();
			em.getTransaction().commit();
		} catch ( Exception e ) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return list;
	}
		
		
}
