package com.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.entity.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller("demoAction")
@Scope("prototype")
public class DemoAction extends ActionSupport{

	private Demo demo;
	
	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

	public String execute() throws Exception {
		
		System.out.println("----demo execute");
		System.out.println(demo);
		
		return SUCCESS;
	}

	public String insertemp() throws Exception {
		
		System.out.println("----demo insertemp");
		
		return SUCCESS;
	}
	
    public String selectemp() throws Exception {
		
		System.out.println("----demo selectemp");
		
		return SUCCESS;
	}
}
