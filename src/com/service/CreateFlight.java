package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.FlightDaoService;

@Path("/createFlight")
public class CreateFlight {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<String> createNewFlight(@FormParam("flightName") String flightName,@FormParam("flightNumber") String flightNumber,@FormParam("fromLocation") String fromLocation,
										@FormParam("toLocation") String toLocation,@FormParam("date") String date,@FormParam("time") String time)
	{
		List<String> loginResponse = new ArrayList<String>();
		FlightDaoService obj=new FlightDaoService();
		boolean status=false;
		
		try {
			status= obj.insertNewFlight(flightName, flightNumber, fromLocation, toLocation, date, time);
			if(status) {
				
				loginResponse.add("Schedule Sucessfully created");
				return loginResponse;
			}
			else {
				loginResponse.add("Schedule Creation fail");
				return loginResponse;
			}
		}
		 catch (Exception e) {
				e.printStackTrace();
			}
			
			return loginResponse;
	}
}
