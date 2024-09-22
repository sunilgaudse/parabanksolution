package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanPage {
	WebDriver driver = null;

	public RequestLoanPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[text()='Request Loan']")
	WebElement requestLoanButton;
	@FindBy(id ="amount")
	WebElement amount;
	@FindBy(id ="downPayment")
	WebElement downPayment;
	@FindBy(xpath = "//input[@value='Apply Now']")
	WebElement applyNowButton;
	public void requestLoanMethod(String amount1, String downpayment1) {
		requestLoanButton.click();
		amount.sendKeys(amount1);
		downPayment.sendKeys(downpayment1);
		applyNowButton.click();
	}
	
	
	

}
