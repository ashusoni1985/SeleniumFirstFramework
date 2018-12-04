package com.orangehrmselenium.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrmselenium.base.TestBase;
import com.orangehrmselenium.pages.AdminPage;
import com.orangehrmselenium.pages.HomePage;
import com.orangehrmselenium.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	AdminPage adminPage;
	
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	@Test(priority=1, description="Verify Section Title")
	public void verifyTitle(){
		Assert.assertTrue(homePage.verifyHomePageMessage("Welcome Admin"));
		
		}
	@Test(priority=2, description="Veify Home Page Title")
	public void verifyPageTitle(){
		Assert.assertTrue(homePage.verifyPageTitle("OrangeHRM"));
	}
	
	@Test(priority=3, description="Verify the Menu Admin")
	public void verifyMenuItem(){
		Assert.assertTrue(homePage.verifyAdminLinkTest("Admin"));
	}
	
	@Test(priority=4, description="Click on the Admin Menu")
	public void clickOnAdminMenu(){
		adminPage = homePage.clickOnAdminMenu();
		//adminPage.verifyText("System Users");
		Assert.assertTrue(adminPage.verifyText("System Users"));
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}

}
