package com.entity;

import java.util.*;

public class Employee implements java.io.Serializable {

	// Fields

	private Integer empid;
	private String empname;
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + "]";
	}

	private Set projects = new HashSet();

	public Employee(Integer empid, String empname, Set projects) {
		
		this.empid = empid;
		this.empname = empname;
		this.projects = projects;
	}

	public Set getProjects() {
		return projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(Integer empid, String empname) {
		this.empid = empid;
		this.empname = empname;
	}

	public Integer getEmpid() {
		return this.empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	
	public String getEmpname() {
		return this.empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

}