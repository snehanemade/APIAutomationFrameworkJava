package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateUserProfileTest {
	
	@Test(description = "Verify that user profile can be updated successfully")
	
	public void getUserProfileTest() {
		
		
		// Login flow
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("snehanemo", "Nemade@90"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		// Get Profile flow
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse  = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "snehanemo");	
		
		
		// Update Profile flow
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.email("info@gmail.com")
				.firstName("Karruna")
				.lastName("Deva")
				.mobileNumber("8004183678")
				.build();
		response = userProfileManagementService.updateProfile(profileRequest, loginResponse.getToken());
		userProfileResponse  = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "snehanemo");
		Assert.assertEquals(userProfileResponse.getFirstName(), "Karruna");	
	}

}
