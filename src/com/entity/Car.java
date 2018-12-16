package com.entity;

public class Car implements java.io.Serializable {

	// Fields

	private Integer carid;
	private String num;
	private String brand;
	
	@Override
	public String toString() {
		return "Car [carid=" + carid + ", num=" + num + ", brand=" + brand
				+ "]";
	}

	private Carport carport; // 车位信息 

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(Integer carid) {
		this.carid = carid;
	}

	/** full constructor */
	public Car(Integer carid, String num, String brand, Carport carport) {
		this.carid = carid;
		this.num = num;
		this.brand = brand;
		this.carport = carport;
	}

	public Integer getCarid() {
		return this.carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Carport getCarport() {
		return carport;
	}

	public void setCarport(Carport carport) {
		this.carport = carport;
	}

}