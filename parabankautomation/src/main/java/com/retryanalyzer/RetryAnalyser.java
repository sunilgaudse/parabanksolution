package com.retryanalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import net.bytebuddy.asm.Advice.AssignReturned;

public class RetryAnalyser implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		int count =0;
		int maxcount =3;
		if(count<maxcount) {
			count++;
			return true;
		}
		return false;
	}
	

}
