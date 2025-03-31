package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public class BaseService {

	private static final String BASE_URI = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;

	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		this.requestSpecification = given().baseUri(BASE_URI);
	}

	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}

	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}

}
