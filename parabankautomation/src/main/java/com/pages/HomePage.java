package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver = null;
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//a[text()='Register']")
	WebElement register;
	@FindBy(xpath ="//a[@href='logout.htm']")
	WebElement logoutButton;
	
	public void registerBtn() {
		register.click();
	}
	public void logout() {
		logoutButton.click();
	}
	
	
	
}
