package com.orangehrmselenium.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrmselenium.base.TestBase;
import com.orangehrmselenium.pages.HomePage;
import com.orangehrmselenium.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public  void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifypageTitle(){
		Assert.assertTrue(loginPage.verifyPageTitle("OrangeHRM"));
	}
	
	@Test(priority=2)
	public void verifyErrorMessage(){
		loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		Assert.assertTrue(loginPage.verifyErrorMessage("Invalid credentials"));
	}
	
	@Test(priority=3)
	public void loginApplication(){
		//homePage = loginPage.loginApplication("Admin", "admin123");
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		homePage = loginPage.clickOnLognButton();
		
	}
	@Test(priority=4)
	public void verifyHomePageMessage(){
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		homePage = loginPage.clickOnLognButton();
		//homePage.verifyHomePageMessage("Welcome Admin");
		Assert.assertTrue(homePage.verifyHomePageMessage("Welcome Admin"));
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
}
