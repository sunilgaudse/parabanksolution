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
import org.testng.annotations.Test;

import com.base.Base;
import com.listener.MyListener;
import com.pages.LoginPage;
import com.pages.OpenAccount;

public class OpenAccountTest extends Base {
	public static Logger log = LogManager.getLogger(OpenAccountTest.class);
	
	LoginPage lp =null;
	OpenAccount oa = null;
	@BeforeSuite
	public void reportInitialisation() {
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage(driver);
		lp.login();
		oa = new OpenAccount(driver);
	}
	
	@Test
	public void openSavingAccount() throws InterruptedException {
		
		oa.openAccountMethod();
		WebElement actual = driver.findElement(By.xpath("//div[@id='rightPanel']//div/child::div[@id='openAccountResult']/h1"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(actual));
		String actualString = actual.getText();
		Assert.assertEquals(actualString, "Account Opened!");
		
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
