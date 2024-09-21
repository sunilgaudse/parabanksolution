package com.base;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {

	public static WebDriver driver = null;
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test =null;
	public static Logger log = LogManager.getLogger(Base.class);
	
	public static void initialization() {
		log.info("======================================================");
		log.info("Initializing the browser.");
		  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		  log.info("Browser initializing completed.");
		  log.info("Opening the URL");
		  driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		  
		  
	}
	public void reportInIt() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReports.html");
		report.attachReporter(spark);
	}
	

}
