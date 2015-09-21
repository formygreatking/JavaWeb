package com.cry.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cry.person.Person;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
/**
 * 使用PreparedStatement
 * @author K550
 *
 */

public class PreparedStatementDemo {
	
	//数据库链接地址
	public final static String URL = "jdbc:mysql://localhost:3306/test_tab";
	//用户名
	public final static String USERNAME = "vince";
	//密码
	public final static String PASSWORD = "123";
	//驱动
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	
	public static void insert(Person p){
		try {
			Class.forName(DRIVER);
			Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into person(name, age, description)values(?,?,?)";
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement(sql);
			//设置占位符对应的值
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update(Person p){
		try {
			Class.forName(DRIVER);
			Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "update person set name = ?, age = ?, description = ?, where id = ?";
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement(sql);
			//设置占位符对应的值
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void detele(Person p){
		try {
			Class.forName(DRIVER);
			Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from person where id = ?";
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement(sql);
			//设置占位符对应的值
			ps.setInt(1, p.getId());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void queryById(int id){
		Person p = null;
		try {
			Class.forName(DRIVER);
			Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select name,age,description from person where id = ?";
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement(sql);
			//设置占位符对应的值
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				p = new Person();
				p.setId(id);
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setDescription(rs.getString("description"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Person p1 = new Person("CRY", 20, "JDBCTEST2");
		Person p2 = new Person(3, "CRY2", 19, "JDBCTEST3");
		
		insert(p1);
		
		update(p2);
		System.out.println("success!");
	}

}
