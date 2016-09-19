package com.xyztech.util;

import com.xyztech.bean.Beans;
import com.xyztech.bean.Chaxun;

public class Sql {
	public   String sql_cx="select a.UID,UName,DepName,SalBasic,SalHouse,SalOld,SalHealth,SalEmp,SalRefund,SalPerformance,SalDate from Employee as a,Department as b,Salary as c where b.DepID=a.DepID and c.UID=a.UID ";
	public String sql_xg="select * from Employee where UID=";
	public String sql_xg_2="update Employee set ";
	public String sql_xg_3="select UID from Employee where UName=";
	public  String sql_chaxun(Chaxun cx){
		Sql sql=new Sql();
		String name=cx.getName();
		String tel=cx.getTelphone();
		int uid=cx.getUid();
		if(!name.equals("")){
			this.sql_cx+=" and a.UName='"+name+"' ";
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
}
