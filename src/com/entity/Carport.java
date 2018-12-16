package com.entity;

public class Carport implements java.io.Serializable {

	// Fields

	private Integer cpid;

	private String location;
	private String cpsize;

	@Override
	public String toString() {
		return "Carport [cpid=" + cpid + ", location=" + location + ", cpsize="
				+ cpsize + "]";
	}

	private Car car;
	
	// Constructors

	/** default constructor */
	public Carport() {
	}

	/** minimal constructor */
	public Carport(Integer cpid) {
		this.cpid = cpid;
	}

	/** full constructor */
	public Carport(Integer cpid, String location, String cpsize) {
		this.cpid = cpid;
	
		this.location = location;
		this.cpsize = cpsize;
	}

	public Integer getCpid() {
		return this.cpid;
	}

	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}
	
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCpsize() {
		return this.cpsize;
	}

	public void setCpsize(String cpsize) {
		this.cpsize = cpsize;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}