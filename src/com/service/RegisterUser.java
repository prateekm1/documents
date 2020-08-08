package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterUserDao;
import com.pojo.LoginResponse;

@Path("/registerUser")
public class RegisterUser {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> registerNewUser(@FormParam("userName") String userName,@FormParam("email") String email,@FormParam("address") String address,
										@FormParam("password") String password)
	{
		List <String> loginResponse = new ArrayList<String>();
		Integer userRecord = 0;
		
		try {
		LoginResponse lr= new LoginResponse();
		RegisterUserDao obj = new RegisterUserDao();
		
		userRecord = obj.checkUseIsExistsbyUserName(userName);
		if(userRecord == 0) {
			boolean status = obj.registerNewUser(userName, email, address, password);
			if(status) {
				loginResponse.add("User Created");
			return loginResponse;
			}
			else {
				loginResponse.add("User not Created");
				return loginResponse;
			}
			
			
		}
		else
		{
			loginResponse.add("User Name Already Exists");
			return loginResponse;
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		loginResponse.add("User Creatation failed");
		return loginResponse;
	}

}
