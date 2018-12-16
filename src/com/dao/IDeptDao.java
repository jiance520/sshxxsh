package com.dao;

import java.util.*;

import com.entity.*;

public interface IDeptDao {

	List<Dept> selectAll();
	
	Dept selectOne(Integer deptno);
	
	void insert(Dept d2) throws Exception;
	
	void update(Dept d2) throws Exception;
	
	void delete(Integer deptno) throws Exception;
	
	void testHql();
	
}
