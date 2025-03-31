package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class CreateAccountTest {
	
	//@Test(description = "Verify if account is created")
	
	public void createAccountTest() {
		SignupRequest signupRequest = new SignupRequest.Builder()
				.userName("asdasd")
				.password("sad")
				.email("infsdasdao@gmail.com")
				.firstName("nasdeha")
				.lastName("shasdarma")
				.mobileNumber("1238856789")
				.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signupRequest);
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	

}
