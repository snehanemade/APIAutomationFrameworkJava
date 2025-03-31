package com.api.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestListener implements ITestListener {

	private static final Logger Logger = LogManager.getLogger(TestListener.class);

	@Override
	public void onStart(ITestContext context) {
		Logger.info("Test suite started !!");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		Logger.info("Started!! - " + result.getMethod().getMethodName());
		Logger.info("Description - " + result.getMethod().getDescription());
	  }
	
	@Override
	public void onFinish(ITestContext context) {
		Logger.info("Test suite completed !!");
	  }
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Logger.info("Passed - " + result.getMethod().getMethodName());
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Logger.error("Failed - " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		Logger.info("Skipped - " + result.getMethod().getMethodName());
	}

}
