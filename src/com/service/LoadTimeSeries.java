package com.service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.TimeSeriesDao;
import com.pojo.ScheduleTimeSeries;

@Path("/loadTimeSeriesById")
public class LoadTimeSeries {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public  List<ScheduleTimeSeries> getFlight(@FormParam("id") String id)
	{
		List<ScheduleTimeSeries> result = null;
		TimeSeriesDao tst = new TimeSeriesDao();
		try {
			result = tst.loadTimeSeriesDatById(Integer.parseInt(id));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
