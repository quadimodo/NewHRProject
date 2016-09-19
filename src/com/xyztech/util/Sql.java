package com.xyztech.util;

import com.xyztech.bean.Chaxun;

public class Sql {
	public   String sql_cx="select a.UID,UName,DepName,SalBasic,SalHouse,SalOld,SalHealth,SalEmp,SalRefund,SalPerformance,SalDate from Employee as a,Department as b,Salary as c where b.DepID=a.DepID and c.UID=a.UID ";
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
}
