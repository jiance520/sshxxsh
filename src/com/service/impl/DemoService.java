package com.service.impl;

import com.service.IDemoService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.*;
import com.dao.*;

@Service("demoService")
public class DemoService implements IDemoService{

	private IDemoDao dao;

	public IDemoDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(IDemoDao dao) {
		this.dao = dao;
	}

	@Override
	public void testHql() {
		dao.testHql();
	}
	
}
