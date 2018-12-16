package com.test.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
import com.entity.*;
import com.service.*;

public class TestEmpHql1 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IEmpService es = (IEmpService)ctx.getBean("empService");
        
        es.testHql();
        System.out.println("--------end");
	}

}
