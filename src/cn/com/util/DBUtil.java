package cn.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import cn.com.config.LoadConfig;

public final class DBUtil {
	static Properties  pop = null;
	
	static{
		/**
		 * 
		 * 获得一个pop，此pop中包含一些以键值对的方式存储的信息
		 * 
		 * */
		pop = LoadConfig.getConfig();
	}
	private DBUtil(){
		
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(pop.getProperty("DRV"));
			con = DriverManager.getConnection(pop.getProperty("URL"),pop.getProperty("USER"),pop.getProperty("PWD"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void free(ResultSet rs,Statement ste,Connection con){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ste != null){
			try {
				ste.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void free(Statement ste,Connection con){
	
		if(ste != null){
			try {
				ste.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
