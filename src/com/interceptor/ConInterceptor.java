package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//Ȩ�޿���
public class ConInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("========ConInterceptor");
		// ȡsession �� �û���Ϣ
		Object obj = arg0.getInvocationContext().getSession().get("userinfo");
		
		if(obj != null){ // �ɹ� ����
			return arg0.invoke();
		}else{
			return "login";
		}
	
	}

}
