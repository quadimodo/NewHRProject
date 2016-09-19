package com.xyztech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xyztech.bean.Beans;
import com.xyztech.util.ExStringInt;
import com.xyztech.util.PublicConnection;
import com.xyztech.util.Sql;

public class TestLogin {
		ArrayList<String> al=new ArrayList<String>();
		private String uname;
		private String upassword;
		private int rankid;
		Connection con=null;
		PreparedStatement pst=null;
		Statement st=null;
		static ResultSet rs=null;
		public int connections(String unames,String upasswords,int rankids){
			this.uname=unames;
			this.upassword=upasswords;
			this.rankid=rankids;
			con=PublicConnection.connections("HR");
			String sql="select * from Employee where UName=? and UPassword=? and RankID=?";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, uname);
				pst.setString(2, upassword);
				pst.setInt(3, rankid);
				rs=pst.executeQuery();
				if(rs.next()){
					return rankid;
				}else
				{
					System.err.println("没有返回值");
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return -1;	
	}
		public Beans testXiugai(String sql){
			Beans bean=new Beans();
			con=PublicConnection.connections("HR");
			try {
				st=con.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next()){
					//将返回的结果放入benan中
					bean.setUsername(rs.getString(5));
					bean.setTelphone(rs.getString(8));
					bean.setDepid(rs.getInt(2));
					bean.setPerid(rs.getInt(4));
					bean.setPassword(rs.getString(6));
					bean.setGender(rs.getString(7));
					bean.setRankid(rs.getInt(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
//				PublicConnection.closeSql(con, pst, rs);
			}
			return bean;
		}
		public void updateUser(String sql){
		con=PublicConnection.connections("HR");
		try {
			st=con.createStatement();
			int i=st.executeUpdate(sql);
			if(i==1){
				System.out.println("成功修改数据");
			}else{
				System.out.println("失败了");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
