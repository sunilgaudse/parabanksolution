package com.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccount {
	public static Logger log = LogManager.getLogger(OpenAccount.class);
	
	WebDriver driver = null;

	public OpenAccount(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[text()='Open New Account']")
	WebElement openNewAccount;
	@FindBy(id = "type")
	WebElement accountType;
//	@FindBy(id="fromAccountId")
//	WebElement accountNumber;
	@FindBy(xpath = "//input[@value ='Open New Account']")
	WebElement submit;
	
	public void openAccountMethod() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		openNewAccount.click();
		Select actypeSelect = new Select(accountType);
		actypeSelect.selectByValue("1");
		
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();	
		log.info("Submit Button Clicked.");
		
	}
 
	
}
