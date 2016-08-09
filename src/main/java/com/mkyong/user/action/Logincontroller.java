package com.mkyong.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@SuppressWarnings("unused")
public class Logincontroller extends ActionSupport {
	

		private static final long serialVersionUID = 1L;
		private String emailid;
		private String pass;
	private Boolean flag=false;

		public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@RequiredStringValidator(message="email is required")
		@EmailValidator(message="wrong format")
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}


		
	@RequiredStringValidator(message="password is required")
	@StringLengthFieldValidator(message="size should be bw 6 to 10",minLength="6",maxLength="10")
	public void setPass(String pass) {
		this.pass = pass;
	}


	
	public String getEmailid() {
		return emailid;
	}
    public String getPass() {
		return pass;
	}

		// all struts logic here
		public String execute() {
	
			return "success";
	 
		}
	
}
