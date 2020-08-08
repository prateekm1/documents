package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.RegisterUserDao;

import com.pojo.LoginResponse;
import com.pojo.User;



@Path("/login")
public class LoginService {
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public List <LoginResponse> myUser(@FormParam ("param1") String user,@FormParam ("param2") String pass)
	{
		List<LoginResponse> list = new ArrayList<LoginResponse>();
		LoginResponse lr = new LoginResponse();
		
		RegisterUserDao regDao = new RegisterUserDao();
		User UserDtl = new User();
		
		if(!user.equals("") && !pass.equals(""))
		{	
			
			UserDtl = regDao.fetchUserDetailsByUserIdPassword(user, pass);
			
			if(UserDtl!=null && UserDtl.getName()!=null ) {
    			
				lr.setStatus("sucess");    		
        		lr.setData("Sucessfully Login");
        		list.add(lr);
        		//System.out.println(UserDtl.getName());
        		return list;
			
		}
			else {
    			lr.setStatus("fail");
        		lr.setData("User name and password Not Valid");
        		list.add(lr);
        		
        		return list;
    		}
    	}else {
    		lr.setStatus("fail");
    		
    		lr.setData("User name and password should not blank");
    		list.add(lr);
    		return list;
    	}
    	
		
		
	}
	
}
