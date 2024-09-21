package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='login']//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//div[@class='login']//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//div[@class='login']//input[@type='submit']")
	WebElement logIn;
	
	public void login() {
		username.sendKeys("sunilgaudse12");
		password.sendKeys("Sunil@1234");
		logIn.click();
	}
}
