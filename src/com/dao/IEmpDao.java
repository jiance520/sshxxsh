package com.dao;

import java.util.*;

import com.entity.*;

public interface IEmpDao {

	List<Emp> selectAll();
	
	Emp selectOne(Short empno);
	
	void testHql();
}
