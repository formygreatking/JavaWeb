package com.cry.test;

import java.sql.SQLException;
import java.sql.Types;

import com.cry.util.db.DBUtils;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class ProcedureDemo {

	public static void callProcedure(){
		Connection conn = null;
		CallableStatement cs = null;
		String sql = "{call javaProcDemo(?, ?)}";
		
		try {
			conn = DBUtils.getConnection();
			cs = (CallableStatement) conn.prepareCall(sql);
			cs.setString(1, "态度");
			cs.registerOutParameter(2, Types.VARCHAR);//注册第二个参数为输出参数
			
			boolean b = cs.execute();//执行
			
			System.out.println(b);
			System.out.println(cs.getString(2));
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.close(null, cs, conn);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		callProcedure();
	}

}
