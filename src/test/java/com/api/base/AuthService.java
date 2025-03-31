package com.api.base;
import java.util.HashMap;

import io.restassured.response.*;

public class AuthService extends BaseService {
	
	private static final String BASE_PATH = "/api/auth";
	
	public Response login(Object payload) {
		return postRequest(payload, BASE_PATH+"/login");
	}
	
	public Response signUp(Object payload) {
		return postRequest(payload, BASE_PATH+"/signup");
	}
	
	public Response forgotPassword(String emailAddress) {
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", emailAddress);
		return postRequest(payload, BASE_PATH+"/forgot-password");
	}


}
