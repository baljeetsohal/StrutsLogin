package com.igt.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.user.action.WelcomeUserAction;

import Model.user;



@SuppressWarnings("unused")
public class RegisterDao {
private WelcomeUserAction w;


public RegisterDao(WelcomeUserAction w)
{
	this.w=w;
}
public int saveintodb()
{  
	
	   Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	     
	    //creating transaction object  
	    Transaction t=session.beginTransaction(); 
   
       user u=w.getUs();
	 int status=0;
		if(u.getId()!=0)
		{
			String hql = "UPDATE user SET first=:first,last=:last,dept=:dept,pass=:pass WHERE id=id";
			Query query = session.createQuery(hql);
			query.setParameter("first",u.getFirst());
			query.setParameter("last",u.getLast());
			query.setParameter("dept",u.getDept());
			query.setParameter("pass",u.getPass());
			query.setParameter("id",u.getId());
			status= query.executeUpdate();
			   session.getTransaction().commit();//persisting the object  
			    session.close();//transaction is commited  
		}
		else
		{    
			long result=0;
			String SQL_QUERY = "SELECT COUNT(*) FROM user where email=:email";
			Query query = session.createQuery(SQL_QUERY);
			 query.setString("email",u.getEmail());
			/*  for(Iterator it=query.iterate();it.hasNext();)
			  {
			   result=(Long)it.next();	      }*/
			 result = (Long)query.uniqueResult();
			  session.getTransaction().commit();
			  session.close();
			  
			if(result==0)
			{  session=factory.openSession(); 
		    //creating transaction object  
		  t=session.beginTransaction();
		/*	//	Query query1 = session.createQuery("insert into user(first,last,dept,email,pass) select u.getFirst(),u.getLast(),u.getDept(),u.getEmail(),u.getPass() from user u");
		status = query1.executeUpdate();*/
		  session.save(u);
		 t.commit();
		  session.close();
		
			}	
	
		     
		}  

		 return status;
}}