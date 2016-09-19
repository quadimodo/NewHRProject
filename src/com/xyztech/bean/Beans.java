package com.xyztech.bean;
//基本信息
public class Beans {
	  private String username,password,telphone,department,permission,gender, rankname;
	  private int rankid,depid,perid;
	  public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public int getPerid() {
		return perid;
	}
	public void setPerid(int perid) {
		this.perid = perid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	 public  String getTelphone() {
		return telphone;
	}
	public  void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public  String getDepartment() {
		return department;
	}
	public  void setDepartment(String department) {
		this.department = department;
	}
	public  String getPermission() {
		return permission;
	}
	public  void setPermission(String permission) {
		this.permission = permission;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRankid() {
		return rankid;
	}
	public void setRankid(int rankid) {
		this.rankid = rankid;
	}
	public Beans(String username, String password, String telphone, String department, String permission, String gender,
			int rankid) {
		super();
		this.username = username;
		this.password = password;
		this.telphone = telphone;
		this.department = department;
		this.permission = permission;
		this.gender = gender;
		this.rankid = rankid;
	}
	public String getRankname() {
		return rankname;
	}
	public void setRankname(String rankname) {
		this.rankname = rankname;
	}
	public Beans() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
