package com.igt.Dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.user;

public class FetchRecordsDao {
   private List<user> list=new ArrayList();
   private user user;

   public List<user> execute()
    {

		   Configuration cfg=new Configuration(); 
		   cfg.configure("hibernate.cfg.xml");
		   SessionFactory factory=cfg.buildSessionFactory();  

		   Session session=factory.openSession();  
		    
		   Transaction t=session.beginTransaction(); 
		   String hql = "from user";
			 Query query = session.createQuery(hql);
			 list=query.list();
			    session.getTransaction().commit();
		        session.close();
		      

	   return list;
	 
	}  
	public user update(int id){  
		 Configuration cfg=new Configuration(); 
		   cfg.configure("hibernate.cfg.xml");
		   SessionFactory factory=cfg.buildSessionFactory();  	   
		   Session session=factory.openSession(); 
	
			 String hql = " from user where id=:id";
			 Query query = session.createQuery(hql);
			 query.setParameter("id",id);
			 List result = query.list();
			  session.getTransaction().commit();
		        session.close();
		     user=(user)result.get(1);
		     return user;
		 
		}  
	}  

