package com.entity;
import java.util.*;

public class Project implements java.io.Serializable {

	// Fields

	private Integer proid;
	private String proname;
	
	@Override
	public String toString() {
		return "Project [proid=" + proid + ", proname=" + proname + "]";
	}

	private Set employees = new HashSet();

	// Constructors

	/** default constructor */
	public Project() {
	}

	public Project(Integer proid, String proname, Set employees) {
	
		this.proid = proid;
		this.proname = proname;
		this.employees = employees;
	}
	
	public Set getEmployees() {
		return employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

	/** full constructor */
	public Project(Integer proid, String proname) {
		this.proid = proid;
		this.proname = proname;
	}

	public Integer getProid() {
		return this.proid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
	}
	
	public String getProname() {
		return this.proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

}