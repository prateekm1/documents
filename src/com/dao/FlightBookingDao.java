package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.ScheduleTimeSeries;

public class FlightBookingDao {
	public List<ScheduleTimeSeries> loadTimeSeriesDatById(Integer id) {
		Statement stmt = null;
		Connection conn = null;
		ScheduleTimeSeries timeSeries =null;
		List<ScheduleTimeSeries> resultArr = new ArrayList<ScheduleTimeSeries>();
		try {
			
			DBConnection dbc = new DBConnection();
			conn = dbc.getConnection();
			
			stmt = conn.createStatement();
			String sql = "SELECT * FROM flight.flight_details where id = '" +id +"'";
//			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				timeSeries = new ScheduleTimeSeries();
				timeSeries.setId(rs.getInt("id"));
				timeSeries.setFlightName(rs.getString("fname"));;
				timeSeries.setFlightNumber(rs.getString("fnumber"));
				timeSeries.setFrom(rs.getString("from"));
				timeSeries.setTo(rs.getString("to"));
						
				resultArr.add(timeSeries);
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
	public boolean bookFlightById(String name,String number, String from,  String to,String userName)
	{
		Statement st=null;
		Connection con=null;
		
		try {
			DBConnection db = new DBConnection();
			con=db.getConnection();
			
			st=con.createStatement();
			
			String sql = "INSERT INTO `flight`.`book` (`fname`, `from`, `to`, `username`, `fnumber` ) VALUES ('"+ name +"','" + from+"','" + to+ "','"+userName+"','"+number+"')";
		
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
	

}
