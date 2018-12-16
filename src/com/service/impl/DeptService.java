package com.service.impl;

import com.service.IDeptService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.*;
import com.dao.*;

@Service("deptService")
public class DeptService implements IDeptService{

	private IDeptDao dao;

	public IDeptDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(IDeptDao dao) {
		this.dao = dao;
	}

	public List<Dept> selectAll() {
		
		return dao.selectAll();
	}

	public Dept selectOne(Integer deptno) {
		
		Dept d2 = dao.selectOne(deptno);
		
		//System.out.println(" emps = " + d2.getEmps());
		
		return d2;
	}

	public void insert(Dept d2) throws Exception {
		dao.insert(d2);
	}

	public void update(Dept d2) throws Exception {
		dao.update(d2);
	}

	public void delete(Integer deptno) throws Exception {
		dao.delete(deptno);
	}

	@Override
	public void testHql() {
		dao.testHql();
	}
	
	
	
	
}
