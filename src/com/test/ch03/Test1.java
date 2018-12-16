package com.test.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
import com.entity.*;
import com.service.*;

public class Test1 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IDemoService ds = (IDemoService)ctx.getBean("demoService");
       
        ds.testHql();
        
        System.out.println("----------end");
	}

}
