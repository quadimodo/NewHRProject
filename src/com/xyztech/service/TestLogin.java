package com.xyztech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xyztech.util.PublicConnection;

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
}
