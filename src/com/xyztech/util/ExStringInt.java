package com.xyztech.util;
//��ȡ���ż���Ŷ�Ӧ������
public class ExStringInt {
	static String st="";
	public String department(int e){
		switch(e){
		case 1:
		return	st="����";
		case 2:
			return	st="������";
		case 3:
			return	st="������";
		case 4:
			return	st="ҵ��";
		case 5:
			return	st="�ܾ���";
		}
		return null;
	}
	//�ܲ�'),('T1'),('T2'),('T3'),('P1'),('P2'),('P3'
	public String Permission(int e){
		switch(e){
		case 1:
			return st="�ܲ�";
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
