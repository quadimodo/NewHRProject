package com.xyztech.action;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;





import com.xyztech.bean.Beans;
import com.xyztech.jframe.YuangongManage;

public class ActionPage {
	Beans beans;
	public void actionpage(int i){
		if(i==1){
		YuangongManage ym=new YuangongManage(beans);
//		String texts="\u6B22\u8FCE"+beans.getUsername()+"\u767B\u5F55MicroSaft\u5458\u5DE5\u7BA1\u7406\u7CFB\u7EDF~";
//		ym.lblNewLabel.setText(texts);
		
		ym.setVisible(true);
		}
	}
	public ActionPage(Beans bean){
		this.beans=bean;
	}
	public ActionPage(){
	}
}
