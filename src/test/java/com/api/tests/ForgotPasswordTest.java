package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	//@Test(description = "Verify if forgot password API is working")
	
	public void forgotPasswordTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("automation@gmail.com");
		System.out.print(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	

}
