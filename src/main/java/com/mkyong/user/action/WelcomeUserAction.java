package com.mkyong.user.action;


import java.util.List;

import com.igt.Dao.DelRecordsDao;
import com.igt.Dao.FetchRecordsDao;
import com.igt.Dao.RegisterDao;
import com.opensymphony.xwork2.ActionSupport;


import Model.user;

public class WelcomeUserAction extends ActionSupport 
{
private static final long serialVersionUID = 1L;
private List<user> listUser;
private FetchRecordsDao fdao;
private user us;
public boolean flag=false;
private int id;
	
	

//@RequiredStringValidator(message="first name is mandatory")
/*	public void setFirst(String first) {
		this.first = first;
}*/
//	public void setLast(String last) {
//		this.last = last;
//	}
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//	public String getFirst() {
//		return first;
//	}
//	public String getLast() {
//		return last;
//	}
//	public String getDept() {
//		return dept;
//	}


//	@RequiredStringValidator(message="email is required")
//	@EmailValidator(message="wrong format")
//	public void setEmail(String email) {
//		this.email = email;
//	}
//@RequiredStringValidator(message="password is required")
	//@StringLengthFieldValidator(message="size should be bw 6 to 10",minLength="6",maxLength="10")
//	public void setPass(String pass) {
//		this.pass = pass;
//	}
//
//public String getEmail() {
//	return email;
//}
//public String getPass() {
//	return pass;
//}
	public FetchRecordsDao getFdao() {
		return fdao;
	}
	public void setFdao(FetchRecordsDao fdao) {
		this.fdao = fdao;
	}


	public user getUs() {
		return us;
	}
	public void setUs(user us) {
		this.us = us;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public List<user> getListUser() {
		return listUser;
	}
	public void setListUser(List<user> listUser) {
		this.listUser = listUser;
	} 

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
public String userlist()
{  
	fdao=new FetchRecordsDao();
	listUser = fdao.execute();
	return "success";
}




   public String register()
   {    
	 
	  RegisterDao dao=new RegisterDao(this); 
	  dao.saveintodb();
	  return "success";
	 
   }

   public String delete()
   {
	 new DelRecordsDao().delete(getId());
	 fdao=new FetchRecordsDao();
	 listUser = fdao.execute();
		return "success";
   }
   
   public String update()
   {
	   flag=true;
	   fdao=new FetchRecordsDao();
		setUs(fdao.update(getId()));
		
		return "success";
		
   }
 

 
   
}