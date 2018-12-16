package com.test.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

import com.entity.*;
import com.service.*;

public class TestEmp1 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IEmpService es = (IEmpService)ctx.getBean("empService");
      
        Emp e2 = es.selectOne(Short.valueOf("7369"));
        
        System.out.println(" e2 = "+e2);
        //System.out.println(" dept = "+e2.getDept());
	}

}
