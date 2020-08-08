package com.service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.FlightDaoService;
import com.pojo.FlightDetails;



@Path("/loadFlightByDate")
public class LoadFlightByDate {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightDetails> loadScheduleByDate(@FormParam("creationDate") String creationDate) {
		
		List<FlightDetails> result =null;
		FlightDaoService sdsi = new FlightDaoService();
		try {
			
			result = sdsi.fetchScheduleBasedonDateOfFlight(creationDate);
		//	System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}

}