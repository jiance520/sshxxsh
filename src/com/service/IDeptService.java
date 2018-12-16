package com.service;

import java.util.*;

import com.entity.*;

public interface IDeptService {
	
    List<Dept> selectAll();
	
	Dept selectOne(Integer deptno);
	
    void insert(Dept d2) throws Exception;
	
	void update(Dept d2) throws Exception;
	
	void delete(Integer deptno) throws Exception;
	
	void testHql();
}
