package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetUserProfileRequestTest {
	
	@Test(description = "Verify that you can get details of user profile")
	
	public void getUserProfileTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("snehanemo", "Nemade@90"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getId(), 556);
		
	}

}
