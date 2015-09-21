package com.cry.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * JDBC事务处理
 * @author K550
 *
 */

public class JDBCTxDemo {
	
	//数据库链接地址
	public final static String URL = "jdbc:mysql://localhost:3306/test_tab";
	//用户名
	public final static String USERNAME = "vince";
	//密码
	public final static String PASSWORD = "123";
	//驱动
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	
	public static void txTest(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "insert to person(name, age, description)vlaues(?,?,?)";
			String sql2 = "update person set name = ?, age = ?, description = ? where id = ?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql1);
			//TODO set ps 中的内容
			ps.executeUpdate();
			ps = (PreparedStatement) conn.prepareStatement(sql2);
			//TODO set ps 中的内容
			ps.executeUpdate();
			
			conn.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//事务回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
