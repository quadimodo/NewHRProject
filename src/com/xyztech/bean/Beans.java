package com.xyztech.bean;
//������Ϣ
public class Beans {
	 static private String username;
	 static private String password;
	 static private int rankid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		Beans.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		Beans.password = password;
	}
	public int getRankid() {
		return rankid;
	}
	public void setRankid(int rankid) {
		Beans.rankid = rankid;
	}
	public Beans(String username, String password, int rankid) {
		super();
		Beans.username = username;
		Beans.password = password;
		Beans.rankid = rankid;
	}
	public Beans() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
