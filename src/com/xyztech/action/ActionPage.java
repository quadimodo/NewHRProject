package com.xyztech.action;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;





import com.xyztech.bean.Beans;
import com.xyztech.jframe.YuangongManage;
import com.xyztech.jframe.alert.XiuGai;
import com.xyztech.service.Connections;
import com.xyztech.service.TestLogin;
import com.xyztech.service.UpdateUser;
import com.xyztech.util.Sql;

public class ActionPage {
	Beans beans;
	XiuGai xg=new XiuGai();
	public void actionpage(int i){
		if(i==1){
		YuangongManage ym=new YuangongManage(beans);
//		String texts="\u6B22\u8FCE"+beans.getUsername()+"\u767B\u5F55MicroSaft\u5458\u5DE5\u7BA1\u7406\u7CFB\u7EDF~";
//		ym.lblNewLabel.setText(texts);
		
		ym.setVisible(true);
		}
	}
	public void actionXiugai(int id){
		Beans bean=new TestLogin().testXiugai(new Sql().sql_xiugai(id));
		xg.textField.setText(bean.getUsername());
		xg.textField.setEditable(false);
		xg.textField_1.setText(bean.getPassword());
		xg.textField_5.setText(bean.getTelphone());
		xg.textField_6.setText(bean.getGender());
		xg.textField_6.setEditable(false);
		xg.comboBox_2.setSelectedIndex(bean.getRankid()-1);
		xg.comboBox.setSelectedIndex(bean.getDepid()-1);
		xg.comboBox_1.setSelectedIndex(bean.getPerid()-1);
		xg.setVisible(true);		
	}
//	public void actionXiugai(XiuGai xg){
//		beans.setUsername(xg.textField.getText());
//		beans.setPassword(xg.textField_1.getText());
//		beans.setTelphone(xg.textField_5.getText());
//		beans.setGender(xg.textField_6.getText());
//		beans.setRankid(xg.comboBox_2.getSelectedIndex()+1);
//		beans.setDepid(xg.comboBox.getSelectedIndex()+1);
//		beans.setPerid(xg.comboBox_1.getSelectedIndex()+1);
//		new TestLogin().updateUser(beans);
//	}
	public ActionPage(Beans bean){
		this.beans=bean;
	}
	public ActionPage(){
	}
}
