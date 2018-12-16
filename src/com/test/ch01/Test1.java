package com.test.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
import com.entity.*;
import com.service.*;

public class Test1 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IDeptService ds = (IDeptService)ctx.getBean("deptService");
        
        Dept d2 = ds.selectOne(Integer.valueOf("60"));
        
        System.out.println(" d2 = "+d2);
        
        //System.out.println(" emps = " + d2.getEmps());
	}

}
