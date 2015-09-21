package com.cry.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * ResultSet方法
 * @author K550
 *
 */
public class JDBCQueryDemo {
	
	//数据库链接地址
		public final static String URL = "jdbc:mysql://localhost:3306/test_tab";
		//用户名
		public final static String USERNAME = "vince";
		//密码
		public final static String PASSWORD = "123";
		//驱动
		public final static String DRIVER = "com.mysql.jdbc.Driver";
		
		public static void query(){
			try {
				Class.forName(DRIVER);
				Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
				String sql = "select id, name, age, description from person";
				Statement state = (Statement) conn.createStatement();
				//执行查询并返回结果集
				ResultSet rs = state.executeQuery(sql);
				
				while(rs.next()){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String description = rs.getString("description");
					System.out.println("id = " + id + " name = " + name + " age = "
					+ age + " description = " + description);
				}
				
				rs.close();
				state.close();
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		query();
	}

}
