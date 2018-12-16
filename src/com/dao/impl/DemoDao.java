package com.dao.impl;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dao.IDemoDao;
import com.entity.*;

@Repository("demoDao")
public class DemoDao extends BaseDao implements IDemoDao{

	@Override
	public void testHql() {
		testSessionFactory2();
	}

	//һ��1
	public void oneToOne(){
        Session ss = getSession();
		
		Car c2 = (Car)ss.get(Car.class, Integer.valueOf("1"));
		
		System.out.println("c2 = "+c2);
		
		System.out.println(" carport = "+c2.getCarport());
	}
	
	//��Զ�
	public void manyToMany(){
	    Session ss = getSession();
			
		Employee e2 = (Employee)ss.get(Employee.class, Integer.valueOf("1"));
			
		System.out.println("e2 = "+e2);
		System.out.println(" projects = "+e2.getProjects());
	}
	
	//����sql
	public void sqlQuery(){
		Session ss = getSession();
		String sql = "select d.* from dept d where d.dname like :name";
		Query q2 = ss.createSQLQuery(sql).addEntity("d", Dept.class);
		      q2.setParameter("name", "S%");
		      
		List<Dept> list = q2.list();
		
		System.out.println(list.get(0).getDname());
		
		Set<Emp> es = list.get(0).getEmps();
		
		for(Emp e2 :es){
			System.out.println("---"+e2.getEname());
		}
	}
	
	// �������� hql
	public void nameHql(){
		Session ss = getSession();
		
		Query  q2 = ss.getNamedQuery("findemp1");
		       q2.setParameter("name", "S%");
		
		       List<Emp> list = q2.list();
		
		       System.out.println(list.get(0).getEname());
	}
	
	// �������� sql
	public void nameSql(){
			Session ss = getSession();
			
			Query  q2 = ss.getNamedQuery("findemp2");
		       q2.setParameter("dno", 20);
		
		       List<Emp> list = q2.list();
		
		       System.out.println(list.get(0).getEname());
	}
	
	//������������:�Զ�ȡ��������
	public void leftJoin(){
		Session ss = getSession();
		
		Query  q2 = ss.createQuery("from Dept d left join fetch d.emps");
		
		List<Dept> list = q2.list();
		
		ss.clear();//���session
	
		System.out.println(list.get(0).getDname());
			
		Set<Emp> es = list.get(0).getEmps();
			
		System.out.println(es.size());	
	}
	
	//���Թ���
	public void testProcedure(){
		Session ss = getSession();
		
		Ework ew = new Ework(7369);
		
		ss.doWork(ew);
		
		System.out.println("Ա������:"+ew.getEname());
	}
	
	//2���������1
	public void testSessionFactory1(){
		Session ss = getSession();
        Object  obj1  =  ss.load(Dept.class, Integer.valueOf("20"));
		
		Dept d1 = (Dept)obj1;
		   
		System.out.println("---"+d1.getDname());
		
		ss.clear();
		
        Object  obj2 =  ss.load(Dept.class, Integer.valueOf("20"));
		
		Dept d2 = (Dept)obj2;
		   
		System.out.println("---"+d2.getDname());
	}
	
	//2���������2
	public void testSessionFactory2(){
		Session ss = getSession();
		
		Query  q2 = ss.createQuery("from Emp");
		List<Emp> list = q2.setCacheable(true).list();
		//List<Emp> list = q2.list();
		System.out.println("------------list = "+list);
		
		Query  q3 = ss.createQuery("from Emp");
		List<Emp> list2 = q3.setCacheable(true).list();
		//List<Emp> list2 = q3.list();
		System.out.println("------------list2 = "+list2);
	}
}
