package com.api.base;

import io.restassured.response.*;

public class UserProfileManagementService extends BaseService {
	
	private static final String BASE_PATH = "/api/users";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+ "/profile");
	}
	
	public Response updateProfile(Object payload, String token) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH+ "/profile");
	}

}
