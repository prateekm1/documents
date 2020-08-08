package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.FlightDetails;


public class FlightDaoService {
	
	public boolean insertNewFlight(String flightName,String flightNumber,String fromLocation,String toLocation,String date,String time)
	{
		Statement st= null;
		Connection con=null;
		
		try {
			
			DBConnection db = new DBConnection();
			con=db.getConnection();
			
			st=con.createStatement();
			
			String sql = "INSERT INTO `flight`.`flight_details` (`fname`, `fnumber`, `from`, `to`, `date`, `time`) VALUES ('"+ flightName +"','"  + flightNumber +"','" + fromLocation +"','" + toLocation +"','" + date +"','" + time  + "')";

			int primaryId=-1;
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			String pri2="-1s";
			ResultSet rs=st.getGeneratedKeys();
			if(rs.next())
			{
				pri2=rs.getString(1);
				
			}
//			primaryId = Integer.parseInt(pri2);
//			Integer timeing = Integer.parseInt(time);
//			
			return true;
			
		}
		catch(Exception e)
		{
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


	public List<FlightDetails> fetchScheduleBasedonDate() {
		Statement stmt = null;
		Connection conn = null;
		FlightDetails usrDtls= null;
		List<FlightDetails> resultArr = new ArrayList<FlightDetails>();
		try {
			usrDtls= new FlightDetails();
			DBConnection dbc = new DBConnection();
			conn = dbc.getConnection();
			
	
			stmt = conn.createStatement();
	
			String sql = "SELECT * FROM flight.flight_details";
	//		System.out.println(sql);
	
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				usrDtls = new FlightDetails();
				usrDtls.setFlightId(rs.getInt("id"));
				usrDtls.setFlightName(rs.getString("fname"));
				usrDtls.setFlightNumber(rs.getString("fnumber"));
				usrDtls.setFrom(rs.getString("from"));
				usrDtls.setTo(rs.getString("to"));
				usrDtls.setDate(rs.getString("date"));
				usrDtls.setTime(rs.getString("time"));
				resultArr.add(usrDtls);
			//	System.out.println(usrDtls.getFlightName());
		    }
			return resultArr;
	
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
		return resultArr;
	}


public List<FlightDetails> fetchScheduleBasedonDateOfFlight(String date) {
	Statement stmt = null;
	Connection conn = null;
	FlightDetails usrDtls= null;
	List<FlightDetails> resultArr = new ArrayList<FlightDetails>();
	try {
		usrDtls= new FlightDetails();
		DBConnection dbc = new DBConnection();
		conn = dbc.getConnection();
		

		stmt = conn.createStatement();

		String sql = "SELECT * FROM flight.flight_details WHERE date='"+date+"'";
//		System.out.println(sql);

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			usrDtls = new FlightDetails();
			usrDtls.setFlightId(rs.getInt("id"));
			usrDtls.setFlightName(rs.getString("fname"));
			usrDtls.setFlightNumber(rs.getString("fnumber"));
			usrDtls.setFrom(rs.getString("from"));
			usrDtls.setTo(rs.getString("to"));
			usrDtls.setDate(rs.getString("date"));
			usrDtls.setTime(rs.getString("time"));
			resultArr.add(usrDtls);
		//	System.out.println(usrDtls.getFlightName());
	    }
		return resultArr;

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
	return resultArr;
}
public List<FlightDetails> fetchFlight() {
	Statement stmt = null;
	Connection conn = null;
	FlightDetails usrDtls= null;
	List<FlightDetails> resultArr = new ArrayList<FlightDetails>();
	try {
		usrDtls= new FlightDetails();
		DBConnection dbc = new DBConnection();
		conn = dbc.getConnection();
		

		stmt = conn.createStatement();

		String sql = "SELECT * FROM flight.book";
//		System.out.println(sql);

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			usrDtls = new FlightDetails();
			usrDtls.setFlightId(rs.getInt("id"));
			usrDtls.setFlightName(rs.getString("fname"));
			usrDtls.setFlightNumber(rs.getString("fnumber"));
			usrDtls.setFrom(rs.getString("from"));
			usrDtls.setTo(rs.getString("to"));
		
			resultArr.add(usrDtls);
		//	System.out.println(usrDtls.getFlightName());
	    }
		return resultArr;

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
	return resultArr;
}
}
