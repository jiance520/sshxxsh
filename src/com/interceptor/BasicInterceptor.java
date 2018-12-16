package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class BasicInterceptor implements Interceptor{

	public void destroy() {
		System.out.println(" basic destroy");
	}

	public void init() {
		System.out.println(" basic init");
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		
		System.out.println(" basic intercept");
		
		
		return arg0.invoke();
	}

}
