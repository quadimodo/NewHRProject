package com.xyztech.bean;

public class Chaxun {
	private String name;
	private String telphone;
	private int uid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Chaxun(String name, String telphone, int uid) {
		super();
		this.name = name;
		this.telphone = telphone;
		this.uid = uid;
	}
	public Chaxun() {
		super();
		// TODO 自动生成的构造函数存根
	}
}
