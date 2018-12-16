package com.entity;

public class Users {

	private int usid;
	private String uname;
	private String upwd;
	private int sex;
	private String sexStr;
	
	private String cardNo;
	private String email;
	private long mobile;
	
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public String getSexStr() {
		
		if(getSex()==1){
			return "ÄÐ";
		}else{
			return "Å®";
		}
	}

	
	public Users() {
		
	}
	
	public Users(int usid, String uname, String upwd, int sex, String cardNo,
			String email, long mobile) {
		
		this.usid = usid;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.cardNo = cardNo;
		this.email = email;
		this.mobile = mobile;
	}

	public String say(String ss){
		
		return ss + "ÑÝ½²";
	}
	
	public static String pk(String ss){
		
		return  ss + "ÔÚpk";
	}
}
