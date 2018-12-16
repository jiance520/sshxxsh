package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

// ����������
public class MethodInterceptor extends MethodFilterInterceptor{

	public String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("--------MethodInterceptor");
		// ȡsession �� �û���Ϣ
		Object obj = arg0.getInvocationContext().getSession().get("userinfo");
				
		if(obj != null){ // �ɹ� ����
			return arg0.invoke();
		}else{
			return "login";
		}
			
	}

}
