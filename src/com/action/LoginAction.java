package com.action;

import com.entity.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	
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
		System.out.println("-------¿ªÊ¼µÇÂ¼");
		
		System.out.println(" name = "+name);
		System.out.println(" password = "+password);
		
		Users u2 = new Users();
		      u2.setUname(name);
		      u2.setUpwd(password);
		session.put("userinfo", u2);
		
		return INPUT;
	}

	public void setRequest(Map<String, Object> request) {
	
		this.request = request;		
		//System.out.println("--------- setRequest...");
	}

	public void setSession(Map<String, Object> session) {
		
		this.session = session;	
		//System.out.println("--------- setSession...");
	}

	public void setApplication(Map<String, Object> application) {
		
		this.application = application;	
		//System.out.println("--------- setApplication...");
	}

}
