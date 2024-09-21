package com.listener;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.graphbuilder.math.func.LgFunction;
import com.utilities.ScreenshotUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener extends Base implements ITestListener{
public static Logger log = LogManager.getLogger(MyListener.class);
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test =report.createTest(result.getName());
		log.info("Test case "+ result.getName()+" execution started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test case is success with name "+ result.getName());
		log.info("Test case success with name " + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, "Test case failed with name " + result.getName());
		log.error("Test case failed with name " + result.getName(),result.getThrowable());
		String pathString = ScreenshotUtility.screenCapture(result.getName());
		test.addScreenCaptureFromPath(pathString);
		log.info("====================================================");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, "Test case skipped with name "+result.getName());
		log.info("Test case skipped with name " + result.getName());
		log.info("====================================================");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}
