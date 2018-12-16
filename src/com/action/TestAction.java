package com.action;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSON;
import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.entity.*;
import com.service.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("testAction")
@Scope("prototype")
public class TestAction extends ActionSupport implements RequestAware,SessionAware,ServletResponseAware{
	
	private IDeptService ds;
	
	private Map<String, Object> session;
	
	private Map<String, Object> request;
	
	private HttpServletResponse response;

	public IDeptService getDs() {
		return ds;
	}

	@Autowired
	public void setDs(IDeptService ds) {
		this.ds = ds;
	}

	private Integer pnum ;
	
	public Integer getPnum() {
		return pnum;
	}

	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}

    public String sbq() throws Exception {
		
    	ActionContext.getContext().put("pnum1", 10);
    	setPnum(Integer.valueOf("5"));
    	
		System.out.println("---------------test sbq");
		return "sbq";
	}

	public String execute() throws Exception {
		System.out.println("-----test execute");
		List<Dept> list = ds.selectAll();
		System.out.println(" list = "+list);
		
		//return "success";
		return "index" ;
	}
	
	public String show() throws Exception {
		System.out.println("-----test show");
		
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
	   this.request = request;
	}

	public String scope() throws Exception {
		System.out.println("-----test scope");
		
		request.put("rnum", 24);
		session.put("snum", 48);
		
		return "scope";
	}

	public void setServletResponse(HttpServletResponse response) {
		  this.response = response;
	}
	
	// ajax ทรฮส าช return null ;
	public String ajax1() throws Exception {
		
		PrintWriter out = response.getWriter();
		
		Dept d2 = new Dept(Integer.valueOf("50"), "soft2", "cssl", null);
		
		String js = JSON.toJSONString(d2);
		System.out.println(" json = "+js);
		
		out.print(js);
		out.flush();
		out.close();
		return null ;
	}
	
}
