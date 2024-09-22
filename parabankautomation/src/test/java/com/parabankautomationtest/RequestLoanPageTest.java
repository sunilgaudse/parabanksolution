package com.parabankautomationtest;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.LoginPage;
import com.pages.RequestLoanPage;

public class RequestLoanPageTest  extends Base{
	public static Logger log = LogManager.getLogger(RequestLoanPageTest.class);
	LoginPage lp = null;
	RequestLoanPage rp = null;
	
	@BeforeSuite
	public void reportInitialisation() {

	}
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage(driver);
		lp.login();
		rp = new RequestLoanPage(driver);
			
	}
	
	@Test(dataProvider = "loanDetails1")
	public void loanApproved(String amount, String downPayment) {
			rp.requestLoanMethod(amount, downPayment);
			WebElement actualResult = driver.findElement(By.xpath("//div[@id='loanRequestApproved']/p[1]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(actualResult));
			String actualResultString = actualResult.getText();
			Assert.assertEquals(actualResultString, "Congratulations, your loan has been approved.");
				
	}
	
	@Test(dataProvider = "loanDetails2")
	public void loanDenied(String amount, String downPayment) {
			rp.requestLoanMethod(amount, downPayment);
			WebElement actualResult = driver.findElement(By.xpath("//div[@id =\"loanRequestDenied\"]/p"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(actualResult));
			String actualResultString = actualResult.getText();
			Assert.assertEquals(actualResultString, "We cannot grant a loan in that amount with your available funds.");
			
	}
	
	@DataProvider
	public Object[][] loanDetails1() {		
		
		return new Object[][] {{"100","20"}};
		
	}
	@DataProvider Object [][] loanDetails2(){
		
		return new Object [][] {{"100000","20"}};
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		log.info("Browser closed.");
		log.info("====================================================");
	}
	@AfterSuite
	public void closeReport() {
		report.flush();
	}

}
