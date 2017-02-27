package org.movie.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	//定义一个EntityManagerFactory,用于创建EntityManager对象
	//它用于取代hibernate的SessionFactoey
	private static EntityManagerFactory emFactory;
	//初始化实体管理器工厂
	static{
		//通过Persistence类的静态方法创建一个EntityManagerFactory
		//createEntityManagerFactory方法的参数指定持久化单元的名称
		emFactory=Persistence.createEntityManagerFactory("mysql_jpa");
	}
	//提供一个方法用于获取EntityManager对象
	//EntityManager对象取代hibernate的Session
	public static EntityManager getEntityManager(){
		//通过EntityManagerFactory来创建EntityManager对象
		return emFactory.createEntityManager();
	}
	public static void main(String[] args) {
		System.out.println(getEntityManager());
	}
}
