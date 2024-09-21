package com.parabankautomationtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pages.HomePage;
import com.pages.RegisterPage;
import com.base.Base;
import com.listener.MyListener;

public class RegisterPageTest extends Base {
	public static Logger log = LogManager.getLogger(RegisterPageTest.class);

	HomePage hp = null;
	RegisterPage rp = null;

	@BeforeSuite
	public void reportInitialisation() {

	}

	@BeforeMethod
	public void setup() {
		initialization();
		hp= new HomePage(driver);
		rp = new RegisterPage(driver);
		
		
		hp.registerBtn();
	}
	@Test(dataProvider = "registrationDetailsData")
	public void registrationSuccessfull(String name, String lastName, String address, String city, String state, String zip, String number, String SSN, String uname, String pass, String Cpass ) {
		String uname2 = uname+ randomGenerator();
		rp.fillRegisterForm( name, lastName, address, city,  state,  zip,  number,  SSN,  uname2,  pass,  Cpass);
		String actualResult = driver.findElement(By.xpath("//div[@id='rightPanel']/child::p")).getText();
		Assert.assertEquals("Your account was created successfully. You are now logged in.", actualResult);
		
	}
	@Test(dataProvider = "registrationDetailsData")
	public void alreadyExistCustomer(String name, String lastName, String address, String city, String state, String zip, String number, String SSN, String uname, String pass, String Cpass ) {
//		rp.fillRegisterForm(name, lastName, address, city,  state,  zip,  number,  SSN,  uname,  pass,  Cpass);
//		hp.logout();
//		hp.registerBtn();
		rp.fillRegisterForm(name, lastName, address, city,  state,  zip,  number,  SSN,  uname,  pass,  Cpass);
		String actualResult = driver.findElement(By.id("customer.username.errors")).getText();
		Assert.assertEquals("This username already exists.", actualResult);
	}
	public int randomGenerator() {
		Random random = new Random();
		int num =random.nextInt(1000);
		return num;		
	}
	
	@DataProvider
	public String[][] registrationDetailsData() { 
		String[][] data =null;
		try {
			XSSFWorkbook workbook = null;
			FileInputStream fis =null;
			
			
			fis = new FileInputStream("userdetails.xlsx");
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int lastRowNum = sheet.getLastRowNum();
			int lastCell = sheet.getRow(lastRowNum).getLastCellNum();
			
			data = new String[lastRowNum][lastCell] ;
			for(int i =1; i<=lastRowNum;i++) {
				Row row = sheet.getRow(i);
				for(int j=0;j<lastCell;j++) {
					Cell cell = row.getCell(j);
					//System.out.println(cell);
					data[i-1][j]=cell.toString();
				}
			}			
			if(workbook!=null) {
				workbook.close();
			}
			if(fis!=null) {
				fis.close();
			}
			
		
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not found the excel sheet.");	
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Could not read the excel sheet.");	
			e.printStackTrace();
		}
		return data;
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
