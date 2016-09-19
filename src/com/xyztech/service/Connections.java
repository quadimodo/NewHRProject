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
				//��Ա���ȼ�Ϊ��ͨԱ��ʱ,ֻ��ʾ����нˮ
				if(rs.next()){
					  countSalarys(al, sumSalary);
				}
				//��Ա���ȼ�Ϊ���ž���ʱ����ʾ��������Ա��нˮ
			}else{
				st=con.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					countSalarys(al, sumSalary);
				}
			}	
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	return al;	
	}
	public static void countSalarys(ArrayList<Salarys> al,int sumSalary){
			try {
				for (int i=4;i<=10;i++){
				rs.getInt(i);
				sumSalary+=rs.getInt(i);//����нˮ�ܶ�
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

