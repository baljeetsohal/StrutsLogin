package com.igt.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import Model.user;
 
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  



public class DelRecordsDao {
   

	public void delete(int id){  
		 //creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	     
	    //creating transaction object  
	    Transaction t=session.beginTransaction(); 
    
       //Use the session to save model objects
       String sql="delete from user where user.id=?";
       Query q=session.createQuery(sql);
       q.setParameter(1,id);
        session.getTransaction().commit();
        session.close();
	
	}  

}