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
 *�����32����¼��ÿҳ��ʾ5����
ҳ��= ��
������¼����%ÿҳ����==0   ҳ��Ϊ��¼����/ÿҳ������
�������� ҳ��Ϊ��¼����/ÿҳ����+1��

��ô��Nҳ��Ҫ��ʾ���������Ǹ���Χ�أ���¼һ���0��ʼ���㣩��
����(N-1)*ÿҳ����<=���<N*ÿҳ����������������� �ڶ�ҳ�Ǵ�(2-1)*5<=���<2*5��
 */
public class Fenye {
	 public static int currentPage = 1; //��ǰҳ����
     public static int totalPage=0;       //��ҳ��
     public static int RowPerPage = 10; //ÿҳ�ļ�¼��
     //public static int column=0;//��¼������е�������
     public static int totalRowCount = 0;//������еļ�¼������
     public static ArrayList<Salarys>resultDate;//�洢�����
     public static int restDate;//��¼�����ҳ������
	public static void xiaYiYe(ArrayList<Salarys> list){
		//������
		resultDate=list;
		totalRowCount=resultDate.size();
		if(totalRowCount%RowPerPage==0){
			//��ҳ��
			totalPage=totalRowCount/RowPerPage;
		}else {
			totalPage=totalRowCount/RowPerPage+1;
		}		
	}
}
