package com.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.entity.*;
import com.service.IEmpService;

@Service("empService")
public class EmpService implements IEmpService{

	private IEmpDao dao;

	public IEmpDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(IEmpDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Emp> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Emp selectOne(Short empno) {
		
		return dao.selectOne(empno);
	}

	@Override
	public void testHql() {
		dao.testHql();
	}
	
	
}
