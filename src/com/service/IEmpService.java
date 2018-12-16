package com.service;

import java.util.*;

import com.entity.*;

public interface IEmpService {

    List<Emp> selectAll();
	
	Emp selectOne(Short empno);
	
	void testHql();
}
