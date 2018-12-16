package com.dao.impl;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dao.IDeptDao;
import com.entity.*;

@Repository("deptDao")
public class DeptDao extends BaseDao implements IDeptDao{

	public List<Dept> selectAll() {
		Session ss = getSession();
		// hql :hibernate 自己的 sql ,查的是类名 和 属性名 
		String hql = "from Dept" ;	
		Query qs = ss.createQuery(hql); 
		List<Dept> list = qs.list();
		return list;
	}

	public Dept selectOne(Integer deptno) {
		Session ss = getSession();
		
		Dept d2 = (Dept)ss.get(Dept.class, deptno);
		//Dept d2 = (Dept)ss.load(Dept.class, deptno);
		
		return d2;
	}

	public void insert(Dept d2) throws Exception {
		Session ss = getSession();
		ss.save(d2);
	}

	public void update(Dept d2) throws Exception {
		Session ss = getSession();
		ss.update(d2);
	}

	public void delete(Integer deptno) throws Exception {
		Session ss = getSession();
		Dept d2 = new Dept();
		     d2.setDeptno(deptno);
		     
		ss.delete(d2);
	}

	@Override
	public void testHql() {
		Session ss = getSession();
		
		Dept dept = (Dept)ss.get(Dept.class, Integer.valueOf("42"));
		dept.setEmps(null);
		
		ss.update(dept);
		System.out.println(" update dept");
	}

	
}
