package com.selenium.listener_code;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersCode implements ITestListener
{

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("test onTestSuccess : "+result.getMethod().getDescription(),true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("test onTestFailure : "+result.getName());

			}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("test onTestSkipped : "+result.getName());

	
	}

}
