package com.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("registerAction")
@Scope("prototype") 
public class RegisterAction extends ActionSupport{

	private String name;
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		System.out.println("-----后台验证----");
		
		return SUCCESS;
	}

	public void validate() {

		 if(name == null || name.trim().equals("")){
			addFieldError("name2", "用户名不能为空!!!");
		 }
				  
		 if(password == null || password.trim().equals("")){
		    addFieldError("password2", "密码不能为空!!!");
		 }
			
		 addActionError("test ActionError");
		 addActionMessage("test ActionMessage");
			
		 System.out.println("-------------------");
		 
		}

}
