package com.xyztech.service;

import java.sql.*;
import java.util.ArrayList;


import com.xyztech.bean.Salarys;
import com.xyztech.util.PublicConnection;


public class Connections {
	Connection con=null;
	PreparedStatement pst=null;
	Statement st=null;
	static ResultSet rs=null;
	
	private String sql="select a.UID,UName,DepName,SalBasic,SalHouse,SalOld,SalHealth,SalEmp,SalRefund,SalPerformance,SalDate from Employee as a,Department as b,Salary as c where b.DepID=a.DepID and c.UID=a.UID and a.UID=(select UID from Employee where UName=? and UPassword=?)";
	String Orinsql="select a.UID,UName,DepName,SalBasic,SalHouse,SalOld,SalHealth,SalEmp,SalRefund,SalPerformance,SalDate from Employee as a,Department as b,Salary as c where b.DepID=a.DepID and c.UID=a.UID and a.UID=(select UID from Employee where UName=? and UPassword=?)";
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	ArrayList<String> al=new ArrayList<String>();
	public  String uname;
	public  String upassword;
	public  int rankid;

	public  ArrayList<Salarys>  returnSalary(){
		ArrayList<Salarys> al=new ArrayList<Salarys>();
		con=PublicConnection.connections("HR");
		int sumSalary=0;
		try {
			if(sql.equals(Orinsql)){
				pst=con.prepareStatement(sql);
				pst.setString(1, this.uname);
				pst.setString(2, this.upassword);
				rs=pst.executeQuery();
				//当员工等级为普通员工时,只显示个人薪水
				if(rs.next()){
					  countSalarys(al, sumSalary);
				}
				//当员工等级为部门经理时，显示部门所有员工薪水
			}else{
				st=con.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					countSalarys(al, sumSalary);
				}
			}	
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	return al;	
	}
	public static void countSalarys(ArrayList<Salarys> al,int sumSalary){
			try {
				for (int i=4;i<=10;i++){
				rs.getInt(i);
				sumSalary+=rs.getInt(i);//计算薪水总额
				}
				Salarys sala=new Salarys(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),
						rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getDate(11),sumSalary
						);
				al.add(sala);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			
			
	}
	}

