package com.xyztech.util;
//获取部门及编号对应的名称
public class ExStringInt {
	static String st="";
	public String department(int e){
		switch(e){
		case 1:
		return	st="财务部";
		case 2:
			return	st="技术部";
		case 3:
			return	st="行政部";
		case 4:
			return	st="业务部";
		case 5:
			return	st="总经办";
		}
		return null;
	}
	//总裁'),('T1'),('T2'),('T3'),('P1'),('P2'),('P3'
	public String Permission(int e){
		switch(e){
		case 1:
			return st="总裁";
		case 2:
			return st="T1";
		case 3:
			return st="T2";
		case 4:
			return st="T3";
		case 5:
			return st="P1";
		case 6:
			return st="P2";
		case 7:
			return st="P3";
		}
		return null;
	}
}
