package com.service;


import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.FlightBookingDao;


@Path("/bookFlightDetails")
public class BookFlightFinal {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public  boolean getFlight(@FormParam("id") String id,@FormParam("name") String Fname,@FormParam("number") String Fnumber,@FormParam("from") String Ffrom,@FormParam("to") String Fto,@FormParam("username") String userName)
	{
		boolean result=false;
	//	List<ScheduleTimeSeries> result = null;
		FlightBookingDao tst = new FlightBookingDao();
		try {
			 result = tst.bookFlightById(Fname,Fnumber,Ffrom,Fto,userName);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	

}
