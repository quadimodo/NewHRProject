package com.xyztech.bean;

import java.sql.Date;
//薪酬
public class Salarys {
	/**
	 * 基本工资
	 * 住房公积金
	 * 养老保险
	 * 医疗保险
	 * 失业保险
	 * 报销金额
	 * 业绩奖金
	 * 总金额
	 * 时间
	 */
	private int salbasic;
	private int salhouse;
	private int salold;
	private int salhealth;
	private int salemp;
	private int salrefund;
	private int salperfomance;
	private int sum;
	private Date saldate;
	private int uid;
	private String uname;
	private String depname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getSalbasic() {
		return salbasic;
	}
	public void setSalbasic(int salbasic) {
		this.salbasic = salbasic;
	}
	public int getSalhouse() {
		return salhouse;
	}
	public void setSalhouse(int salhouse) {
		this.salhouse = salhouse;
	}
	public int getSalold() {
		return salold;
	}
	public void setSalold(int salold) {
		this.salold = salold;
	}
	public int getSalhealth() {
		return salhealth;
	}
	public void setSalhealth(int salhealth) {
		this.salhealth = salhealth;
	}
	public int getSalemp() {
		return salemp;
	}
	public void setSalemp(int salemp) {
		this.salemp = salemp;
	}
	public int getSalrefund() {
		return salrefund;
	}
	public void setSalrefund(int salrefund) {
		this.salrefund = salrefund;
	}
	public int getSalperfomance() {
		return salperfomance;
	}
	public void setSalperfomance(int salperfomance) {
		this.salperfomance = salperfomance;
	}
	public Date getSaldate() {
		return saldate;
	}
	public void setSaldate(Date saldate) {
		this.saldate = saldate;
	}
	public Salarys(int uid,String uname,String depname,int salbasic, int salhouse, int salold, int salhealth,
			int salemp, int salrefund, int salperfomance, Date saldate,int sum) {
		super();
		this.salbasic = salbasic;
		this.salhouse = salhouse;
		this.salold = salold;
		this.salhealth = salhealth;
		this.salemp = salemp;
		this.salrefund = salrefund;
		this.salperfomance = salperfomance;
		this.saldate = saldate;
		this.sum=sum;
		this.uid=uid;
		this.uname=uname;
		this.depname=depname;
	}
	public Salarys() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
