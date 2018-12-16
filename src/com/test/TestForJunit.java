package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.service.*;
import com.entity.*;

import java.util.*;

@ContextConfiguration(locations="/applicationContext.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback=true)
public class TestForJunit extends AbstractTransactionalJUnit4SpringContextTests{

    private IDeptService  deptService;
	
	public IDeptService getDeptService() {
		return deptService;
	}

	@Autowired
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	@Test
	public void testList(){
		List<Dept> list = deptService.selectAll();
		
		System.out.println(list.size());
	}
	
	@Test
	public void testInsert() throws Exception{
		Dept d2 = new Dept();
		d2.setDeptno(Integer.valueOf("50"));
        d2.setDname("Èí¼þ²¿");
        d2.setLoc("cssl");
        
		deptService.insert(d2);
		System.out.println("-------end insert");
	}
}
