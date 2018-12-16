package com.test.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

import com.entity.*;
import com.service.*;

public class Test3 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IDeptService ds = (IDeptService)ctx.getBean("deptService");
        Dept d2 = new Dept();
             //d2.setDeptno(Byte.valueOf("50"));
             d2.setDname("soft");
             d2.setLoc("cssl");
             
            try {
				ds.insert(d2);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
        System.out.println(" deptno = "+d2.getDeptno());
        System.out.println(" --------end ");
	}

}
