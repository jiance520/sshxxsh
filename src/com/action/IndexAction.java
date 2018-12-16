package com.action;

import com.entity.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	
	private Integer num ;
	
	private Dept dept;
	
	private Date times;

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	
	public String execute() throws Exception {
		System.out.println("------index execute");
		boolean ck = false ;
		//request = (Map)ActionContext.getContext().get("request");
		//session = ActionContext.getContext().getSession();
		//application = ActionContext.getContext().getApplication();
		request.put("rnum", "r1");
		session.put("snum", "s1");
		application.put("anum", "a1");
		
		return INPUT; // input
	}

	public String form1() throws Exception {
		System.out.println("------index form1");
		
		System.out.println(" num = "+num);
		System.out.println(" dept = "+dept);
		System.out.println(" times = "+times);
		
		return SUCCESS;
	}
	
	/*
	 * “¿¿µ◊¢»Î DI
	 * @see org.apache.struts2.interceptor.RequestAware#setRequest(java.util.Map)
	 */
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
