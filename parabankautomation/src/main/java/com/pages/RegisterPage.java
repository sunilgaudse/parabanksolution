package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver = null;
	
	public RegisterPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	
}
	@FindBy(id ="customer.firstName")
	WebElement firstName;
	@FindBy(id ="customer.lastName")
	WebElement lastName;
	@FindBy(id ="customer.address.street")
	WebElement address;
	@FindBy(id ="customer.address.city")
	WebElement city;
	@FindBy(id ="customer.address.state")
	WebElement state;
	@FindBy(id ="customer.address.zipCode")
	WebElement zipCode;
	@FindBy(id ="customer.phoneNumber")
	WebElement phoneNumber;
	@FindBy(id ="customer.ssn")
	WebElement SSN;
	@FindBy(id ="customer.username")
	WebElement username;
	@FindBy(id ="customer.password")
	WebElement password;
	@FindBy(id ="repeatedPassword")
	WebElement confirmPassword;
	@FindBy(xpath = "//input[@value='Register']")
	WebElement submit;
	
	
	
	public void fillRegisterForm(String name ,String lastName1, String address1, String city1, String state1, String zip1, String number1, String SSN1, String uname1, String pass1, String Cpass) {
		firstName.sendKeys(name);
		lastName.sendKeys(lastName1);
		address.sendKeys(address1);
		city.sendKeys(city1);
		state.sendKeys(address1);
		zipCode.sendKeys(zip1);
		phoneNumber.sendKeys(number1);
		SSN.sendKeys(SSN1);
		
		username.sendKeys(uname1);
		password.sendKeys(pass1);
		confirmPassword.sendKeys(Cpass);
		submit.click();
	}


}
