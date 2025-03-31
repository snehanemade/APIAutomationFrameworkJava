package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {

	private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec); // Request is going to be executed
		logResponse(response);
		return response;  // returned to test for assertion
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		Logger.info("BaseURI" + requestSpec.getBaseUri());
		Logger.info("Request Header" + requestSpec.getHeaders());
		Logger.info("Request Payload" + requestSpec.getBody());
	}
	
	public void logResponse(Response response) {
		Logger.info("Status Code" + response.getStatusCode());
		Logger.info("Response Header" + response.getHeaders());
		Logger.info("Request Body" + response.getBody().prettyPrint());
	}
}
