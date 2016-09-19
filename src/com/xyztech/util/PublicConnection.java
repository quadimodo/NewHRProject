package com.xyztech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PublicConnection {
	final static String URL="jdbc:sqlserver://localhost:1433;DataBaseName="; 
	 final static String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 static Connection con=null;
	public static Connection connections(String tablename){
		 try {
			 //1.驱动类载入虚拟机
			Class.forName(DRIVER);
			//2.加载驱动
			con=DriverManager.getConnection(URL+tablename, "sa", "sasa");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 return con;
	}
	public static void closeSql(Connection con,Statement st,ResultSet rs){
		
			try {
				if(con!=null)con.close();
				if(st!=null)st.close();
				if(rs!=null)rs.close();
				System.out.println("-----------成功关闭SQL链接---------");
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	public static void closeSql(Connection con,PreparedStatement pst,ResultSet rs){
		
		try {
			if(con!=null)con.close();
			if(pst!=null)pst.close();
			if(rs!=null)rs.close();
			System.out.println("-----------成功关闭SQL链接---------");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
}
}
