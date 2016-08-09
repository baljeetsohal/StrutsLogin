package com.mkyong.user.action;


import java.util.List;

import com.igt.Dao.DelRecordsDao;
import com.igt.Dao.FetchRecordsDao;
import com.igt.Dao.RegisterDao;
import com.opensymphony.xwork2.ActionSupport;


import Model.user;

public class WelcomeUserAction extends ActionSupport  {
private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FetchRecordsDao getFdao() {
		return fdao;
	}
	public void setFdao(FetchRecordsDao fdao) {
		this.fdao = fdao;
	}


	private List<user> listUser;
	private FetchRecordsDao fdao;
	private user user;
	private user s;
	public boolean flag=false;
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

public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
public String userlist()
{  
	 fdao=new FetchRecordsDao();
	listUser = fdao.execute();
	return "success";
}
   public String register()
   {    s=getUser();
	 
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
		setUser(fdao.update(getId()));
		
		return "success";
		
   }
 
public List<user> getListUser() {
	return listUser;
}
public void setListUser(List<user> listUser) {
	this.listUser = listUser;
}
public user getUser() {
	return user;
}
public void setUser(user user) {
	this.user = user;
}

   
   
}