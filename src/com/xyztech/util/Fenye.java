package com.xyztech.util;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;

import com.xyztech.bean.Salarys;
import com.xyztech.jframe.Login;
import com.xyztech.jframe.ManageHr;
import com.xyztech.service.CreateTable;

/**
 * 
 * @author Administrator
 *如果有32条记录，每页显示5条；
页数= （
——记录条数%每页条数==0   页数为记录条数/每页条数；
——否则 页数为记录条数/每页条数+1；

那么第N页所要显示的数据是那个范围呢（记录一般从0开始计算）？
——(N-1)*每页条数<=序号<N*每页条数。如上面的例子 第二页是从(2-1)*5<=序号<2*5；
 */
public class Fenye {
	 public static int currentPage = 1; //当前页码数
     public static int totalPage=0;       //总页数
     public static int RowPerPage = 10; //每页的记录数
     //public static int column=0;//记录结果集中的列总数
     public static int totalRowCount = 0;//结果集中的记录行总数
     public static ArrayList<Salarys>resultDate;//存储结果集
     public static int restDate;//记录中最后页的总数
	public static void xiaYiYe(ArrayList<Salarys> list){
		//总条数
		resultDate=list;
		totalRowCount=resultDate.size();
		if(totalRowCount%RowPerPage==0){
			//总页数
			totalPage=totalRowCount/RowPerPage;
		}else {
			totalPage=totalRowCount/RowPerPage+1;
		}		
	}
}
