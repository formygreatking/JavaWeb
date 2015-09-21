package com.cry.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cry.dao.PersonDAO;
import com.cry.person.Person;
import com.cry.util.db.DBUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PersonDaoImpl implements PersonDAO{

	/**
	 * PersonDao的具体实现类
	 */
	public void add(Person p) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into person(name, age, description)values(?, ?, ?)";
		try{
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}

	public void update(Person p) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update person set name = ?, age = ?, description = ? where id = ?";
		try{
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}

	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from person where id = ?";
		try{
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}

	public Person findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		String sql = "select name,age,description from person where id = ?";
		
		try{
			conn = DBUtils.getConnection();
		    ps = (PreparedStatement) conn.prepareStatement(sql);
		    ps.setInt(1, id);
		    rs = ps.executeQuery();
		    if(rs.next()){
		    	p = new Person();
		    	p.setId(id);
		    	p.setName(rs.getString(1));
		    	p.setAge(rs.getInt(2));
		    	p.setDescription(rs.getString(3));
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return p;
	}

	public List<Person> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		List<Person> persons = new ArrayList<Person>();
		String sql = "select id,name,age,description from person where id = ?";
		
		try{
			conn = DBUtils.getConnection();
		    ps = (PreparedStatement) conn.prepareStatement(sql);
		    rs = ps.executeQuery();
		    while(rs.next()){
		    	p = new Person();
		    	p.setId(rs.getInt(1));
		    	p.setName(rs.getString(2));
		    	p.setAge(rs.getInt(3));
		    	p.setDescription(rs.getString(4));
		    	persons.add(p);
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return persons;
	}
	
}
