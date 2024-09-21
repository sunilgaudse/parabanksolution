package com.parabankautomationtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.Base;
import com.listener.MyListener;
import com.pages.LoginPage;

public class LoginPageTest extends Base {
	public static Logger log = LogManager.getLogger(LoginPageTest.class);
	LoginPage lp = null;
	@BeforeSuite
	public void reportInitialisation() {
		reportInIt();
		
	}
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage(driver);
	}
	
	@Test
	public void SuccessfulLogin() {
		lp.login();
		String actualResultString = driver.findElement(By.xpath("//b[text()='Welcome']")).getText();
		Assert.assertEquals(actualResultString, "Welcome");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Browser closed.");
		log.info("====================================================");
	}
	
	@AfterSuite
	public void closeReport() {
		report.flush();
	}

}
