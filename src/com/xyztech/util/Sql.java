package com.xyztech.util;

import com.xyztech.bean.Beans;
import com.xyztech.bean.Chaxun;

public class Sql {
	public   String sql_cx="select a.UID,UName,DepName,SalBasic,SalHouse,SalOld,SalHealth,SalEmp,SalRefund,SalPerformance,SalDate from Employee as a,Department as b,Salary as c where b.DepID=a.DepID and c.UID=a.UID ";
	public String sql_xg="select * from Employee where UID=";
	public String sql_xg_2="update Employee set ";
	public String sql_xg_3="select UID from Employee where UName=";
	public String sql_delete="delete from Employee where ";
	public String sql_delete_3;
	//(select UID from Employee where UName='lpmj' and UTelphone='111111')
	public String sql_delete_2="delete from Salary where UID=";
	public String sql_insert="insert Employee (DepID,RankID,PerID,UName,UPassword,UGender,UTelphone) values(";
	public  String sql_chaxun(Chaxun cx){
		String name=cx.getName();
		String tel=cx.getTelphone();
		int uid=cx.getUid();
		if(!name.equals("")){
			this.sql_cx+=" and a.UName like '%"+name+"%'  ";
		}
		if(!tel.equals("")){
			this.sql_cx+=" and a.UTelphone='"+tel+"' ";
		}
		if(uid!=0){
			this.sql_cx+=" and a.DepID="+uid+" ";
		}
		return this.sql_cx;
	}
	public String sql_xiugai(int id){
//		Sql sql=new Sql();
		this.sql_xg+=id;
		return this.sql_xg;
	}
	public String sql_xiugai(Beans bean){
		String name=bean.getUsername();
		String tel=bean.getTelphone();
		String password=bean.getPassword();
		String gender=bean.getGender();
		int rankid=bean.getRankid();
		int depid=bean.getDepid();
		int perid=bean.getPerid();
		this.sql_xg_2+=" UTelphone='"+tel+"',UPassword='"+password+"',RankID="+rankid+",DepID="+depid+" ,PerID="+perid+" where  UName='"+name+"' and UGender='"+gender+"'";
		return this.sql_xg_2;
	}
	public String sql_delete(Beans bean){
		String name=bean.getUsername();
		String tel=bean.getTelphone();
		this.sql_delete+="UName='"+name+"' and UTelphone='"+tel+"' ;";
		this.sql_delete_2+="(select UID from Employee where UName='"+name+"' and UTelphone='"+tel+"');";
		this.sql_delete_3=this.sql_delete_2+this.sql_delete;
		return this.sql_delete_3;
	}
	public String sql_inset(Beans bean){
		String name=bean.getUsername();
		String tel=bean.getTelphone();
		String password=bean.getPassword();
		String gender=bean.getGender();
		int rankid=bean.getRankid();
		int depid=bean.getDepid();
		int perid=bean.getPerid();
		//1,2,3,'ddda','123','ÄÐ','3451');";
		this.sql_insert+=depid+", "+rankid+", "+perid+", '"+name+"' , '"+password+"' , '"+gender+"' , '"+tel+"' )";
		return this.sql_insert;
	}
}
