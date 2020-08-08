package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pojo.User;

public class RegisterUserDao {

	
	public boolean registerNewUser(String userName,String email, String address,  String password)
	{
		Statement st=null;
		Connection con=null;
		
		try {
			DBConnection db = new DBConnection();
			con=db.getConnection();
			
			st=con.createStatement();
			
			String sql = "INSERT INTO `flight`.`user` (`userName`, `email`, `address`, `password` ) VALUES ('"+ userName +"','"  + email +"','" + address+"','" + password+ "' )";
		
			st.executeUpdate(sql);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		return false;
		
		
	}

public User fetchUserDetailsByUserIdPassword(String userName, String pass) {
	Statement stmt = null;
	Connection conn = null;
	User usr= null;
	try {
		usr= new User();
		DBConnection dbc = new DBConnection();
		conn = dbc.getConnection();
		

		stmt = conn.createStatement();

		String sql = "SELECT  userName, email, address,password FROM flight.user where userName = '" + userName + "' and password = '" + pass +"'";
//		System.out.println(sql);

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			
			usr.setName(rs.getString("userName"));
			usr.setEmail(rs.getString("email"));
			usr.setAddress(rs.getString("address"));
		
			usr.setPassword(rs.getString("password"));
			
	        
	    }
		return usr;

	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	}
	return usr;
}


public Integer checkUseIsExistsbyUserName(String userName) {
	Statement stmt = null;
	Connection conn = null;
	Integer resultRecord = 0;
	try {
		
		DBConnection dbc = new DBConnection();
		conn = dbc.getConnection();
		

		stmt = conn.createStatement();

		String sql = "SELECT  userName, email, address,  password FROM flight.user where userName = '" + userName + "'";
//		System.out.println(sql);

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			
			resultRecord++;
	    }
		return resultRecord;

	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	}
	return resultRecord;
}
}
