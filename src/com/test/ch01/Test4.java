package com.test.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

import com.entity.*;
import com.service.*;

public class Test4 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IDeptService ds = (IDeptService)ctx.getBean("deptService");
      
            try {
				ds.delete(Integer.valueOf("50"));
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
        
        System.out.println(" --------end ");
	}

}
