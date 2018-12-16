package com.entity;

import java.util.Date;

/**
 * Demo entity. @author MyEclipse Persistence Tools
 */

public class Demo implements java.io.Serializable {

	// Fields

	private Long did;
	private String dname;
	private Date dtime;

	// Constructors

	/** default constructor */
	public Demo() {
	}

	/** minimal constructor */
	public Demo(Long did) {
		this.did = did;
	}

	/** full constructor */
	public Demo(Long did, String dname, Date dtime) {
		this.did = did;
		this.dname = dname;
		this.dtime = dtime;
	}

	// Property accessors

	public Long getDid() {
		return this.did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Date getDtime() {
		return this.dtime;
	}

	public void setDtime(Date dtime) {
		this.dtime = dtime;
	}

}