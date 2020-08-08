package com.service;

import java.util.List;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.FlightDaoService;
import com.pojo.FlightDetails;



@Path("/loadFlightUser")
public class LoadFlightUser {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightDetails> loadScheduleByDate() {
		
		List<FlightDetails> result =null;
		FlightDaoService sdsi = new FlightDaoService();
		try {
			
			result = sdsi.fetchFlight();
		//	System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}

}
