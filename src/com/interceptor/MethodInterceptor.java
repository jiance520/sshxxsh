package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

// 方法拦截器
public class MethodInterceptor extends MethodFilterInterceptor{

	public String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("--------MethodInterceptor");
		// 取session 的 用户信息
		Object obj = arg0.getInvocationContext().getSession().get("userinfo");
				
		if(obj != null){ // 成功 放行
			return arg0.invoke();
		}else{
			return "login";
		}
			
	}

}
