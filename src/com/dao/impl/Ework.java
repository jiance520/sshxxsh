package com.dao.impl;

import java.sql.*;
import java.util.*;
import com.entity.*;
import oracle.jdbc.OracleTypes;
import org.hibernate.*;
import org.hibernate.jdbc.Work;

public class Ework implements Work{

	private int empno;
	private String ename;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Ework(int empno) {
		this.empno = empno;
	}

	/*
	
create or replace
procedure showename(eno number,ename2 out varchar2)
 as
    name2 emp.ename%type ;
 begin
      -- 赋值
      select ename into name2 from emp where empno = eno ;
      -- 输出
      ename2 := name2 ;
      dbms_output.put_line(' 员工姓名：'||name2);
      exception
         when no_data_found  then
         dbms_output.put_line(' 不存在该员工!!');
 end ;
	
	 */
	public void execute(Connection arg0) throws SQLException {
		  String sql ="{call showename(?,?)}";
		  CallableStatement  stmt = arg0.prepareCall(sql);
		              stmt.setInt(1, getEmpno());
		              //注册出参
		              stmt.registerOutParameter(2, OracleTypes.VARCHAR);
		              //执行过程
		              stmt.execute();
		              //取值
		           String ss = stmt.getString(2);
		
		  setEname(ss);         
	}
}
