package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pojo.Login;

@Path("/adminLogin")
public class AdminLogin {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Login> myAdmin(@FormParam("param1") String userName, @FormParam ("param2") String password )
	{
		List<Login> loginRes = new ArrayList<Login>();
		Login l = new Login();
		
		if(userName.equals(l.getUserName()) && password.equals(l.getPassword()))
		{
			l.setStatus("sucess");
			l.setData("login sucessfull");
			
			loginRes.add(l);
			return loginRes;
					
		}
		else
		{
			l.setStatus("fail");
			l.setData("login unsucessfull");
			
			loginRes.add(l);
			return loginRes;
		}
	}
}
