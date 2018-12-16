package com.test.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
import com.entity.*;
import com.service.*;

public class TestDeptHql1 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IDeptService ds = (IDeptService)ctx.getBean("deptService");
        
        ds.testHql();
        System.out.println("--------end");
	}

}
