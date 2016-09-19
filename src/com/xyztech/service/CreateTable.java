package com.xyztech.service;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.xyztech.bean.Beans;
import com.xyztech.bean.Salarys;
import com.xyztech.util.Fenye;

public class CreateTable {
	ArrayList<Salarys> al=new ArrayList<Salarys>();
	public void preTalbeBuild(Beans bean){
		Connections connect =new Connections();
		connect.uname=bean.getUsername();
		connect.upassword=bean.getPassword();
		al=connect.returnSalary();
	}
	public void preTableBuild(ArrayList<Salarys> array){
		this.al=array;
	}
	//表格的创建
	public DefaultTableModel putSalary(){
		Fenye.xiaYiYe(al);
		Object[][] obj=new Object[Fenye.RowPerPage][12];
		
		int start=Fenye.RowPerPage*(Fenye.currentPage-1);
		int end=Fenye.RowPerPage*Fenye.currentPage;
		if(Fenye.currentPage==Fenye.totalPage&&Fenye.totalRowCount%Fenye.RowPerPage!=0){
			start=Fenye.totalRowCount-Fenye.totalRowCount%Fenye.RowPerPage;
			end=Fenye.totalRowCount;
		}
		for(int x=start,j=0;x<end;x++,j++){
			obj[j][0]=al.get(x).getUid();
			obj[j][1]=al.get(x).getUname();
			obj[j][2]=al.get(x).getDepname();
			obj[j][3]=al.get(x).getSalbasic();
			obj[j][4]=al.get(x).getSalhouse();
			obj[j][5]=al.get(x).getSalold();
			obj[j][6]=al.get(x).getSalhealth();
			obj[j][7]=al.get(x).getSalemp();
			obj[j][8]=al.get(x).getSalrefund();
			obj[j][9]=al.get(x).getSalperfomance();
			obj[j][10]=al.get(x).getSaldate();
			obj[j][11]=al.get(x).getSum();
		}
		DefaultTableModel defaulttablemodel=new DefaultTableModel(obj,
				new String[] {
					"员工编号","员工姓名","员工部门","\u57FA\u672C\u5DE5\u8D44", "\u4F4F\u623F\u516C\u79EF\u91D1", "\u517B\u8001\u4FDD\u9669",
					"\u533B\u7597\u4FDD\u9669", "\u5931\u4E1A\u4FDD\u9669", 
					"\u62A5\u9500\u91D1\u989D", "\u4E1A\u7EE9\u5956\u91D1", "\u6708\u4EFD", "\u603B\u8BA1"});

		return defaulttablemodel;
	}
}
