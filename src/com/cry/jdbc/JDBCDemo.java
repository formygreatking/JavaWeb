package com.cry.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * JDBC的增删改操作
 * 使用Statement会造成SQL注入安全性问题
 * @author K550
 *
 */
public class JDBCDemo {
	//数据库链接地址
	public final static String URL = "jdbc:mysql://localhost:3306/test_tab";
	//用户名
	public final static String USERNAME = "vince";
	//密码
	public final static String PASSWORD = "123";
	//驱动
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	
	/**
	 * 删除操作
	 */
	public static void delete(){
		try {
			Class.forName(DRIVER);
			
			Connection Conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "delete from person where id = 1";
			
			Statement State = (Statement) Conn.createStatement();
			
			State.executeUpdate(sql);
			
			State.close();
			Conn.close();
			
			System.out.println("delete success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 更新操作
	 */
	public static void update(){
		try {
			Class.forName(DRIVER);
			
			Connection Conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "update person set age = 19 where id = 1";
			
			Statement State = (Statement) Conn.createStatement();
			
			State.executeUpdate(sql);
			
			State.close();
			Conn.close();
			
			System.out.println("update success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 插入操作
	 */
	public static void insert(){
		//1、加载数据库驱动程序
		try {
			Class.forName(DRIVER);
	
			//2、获取数据库连接
			Connection Conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3、构造SQL语句
			String sql = "insert into person(name, age, description)values('CRY', 20, 'JDBC测试')";
			
			//4、构造一个Statement实例（用来发送SQL语句的载体）
			Statement State = (Statement) Conn.createStatement();
			
			//5、执行SQL语句，仅仅是将语句发送给数据库
			State.executeUpdate(sql);
			
			//6、关闭连接（释放资源）
			State.close();
			Conn.close();
			
			System.out.println("insert success!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//update();
		insert();
		//delete();
	}

}
