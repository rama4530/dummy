package net.application.service;

public class loginService {
	
	public boolean authenticateUser(String userId,String password) {
		System.out.println(userId);
		System.out.println(password);
		if(userId==null || password==null ||password.trim()=="") {
			return false;
		}else if(!userId.equals("Admin") && !password.equals("Admin")) {
			return false;
		}
		
		return true;
	}
	
	
	
}
