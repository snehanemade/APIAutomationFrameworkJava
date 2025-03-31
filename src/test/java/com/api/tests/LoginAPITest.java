package com.api.tests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.*;

@Listeners(com.api.listeners.TestListener.class)

public class LoginAPITest {
	
	@Test(description = "Verify if login is working")
	
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("snehanemo", "Nemade@90");
		AuthService authService = new AuthService();
		
		// Serialization happens here
		Response response = authService.login(loginRequest);
		
		// De-serialization 
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.print(loginResponse.getToken());
		System.out.print(loginResponse.getEmail());
		System.out.print(loginResponse.getId());
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "info@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 556);
	}

}
