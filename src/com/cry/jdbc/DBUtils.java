package com.cry.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * 数据库操作工具类
 * @author K550
 *
 */

public class DBUtils {
	
	//数据库链接地址
	public final static String URL = "jdbc:mysql://localhost:3306/test_tab";
	//用户名
	public final static String USERNAME = "vince";
	//密码
	public final static String PASSWORD = "123";
	//驱动
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	
	private DBUtils(){}
	
	//使用静态块加载驱动
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//定义一个获取数据库连接的方法
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取连接失败");
		}
		return conn;
	}
	
	//关闭数据库连接
	public static void close(ResultSet rs, Statement state, Connection conn){
		try {
			if(rs != null) rs.close();
			if(state != null) state.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
