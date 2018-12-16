package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//权限控制
public class ConInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("========ConInterceptor");
		// 取session 的 用户信息
		Object obj = arg0.getInvocationContext().getSession().get("userinfo");
		
		if(obj != null){ // 成功 放行
			return arg0.invoke();
		}else{
			return "login";
		}
	
	}

}
