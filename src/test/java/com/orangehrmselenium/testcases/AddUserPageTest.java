package com.orangehrmselenium.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.orangehrmselenium.base.TestBase;
import com.orangehrmselenium.pages.AddUserPage;
import com.orangehrmselenium.pages.AdminPage;
import com.orangehrmselenium.pages.HomePage;
import com.orangehrmselenium.pages.LoginPage;
import com.orangehrmselenium.utils.TestUtil;

public class AddUserPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	AdminPage adminPage;
	AddUserPage addUserPage;
	String sheetName = "AddUser";
	Logger log = Logger.getLogger(AddUserPageTest.class); 
	
	public AddUserPageTest(){
		super();
	}
	
	@BeforeMethod
	public  void setUp(){
		initialization();
		log.info("Initialize the browser");
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		adminPage = homePage.clickOnAdminMenu();
		addUserPage = adminPage.clickOnAddButton();
	}
	@Test(priority=1, description= "Verify whether page displayed or not" )
	public void VerifyPagDisplayed(){
		log.info("Verify the Page Title");
		Assert.assertTrue(addUserPage.verifyUserPageDisplayed("Add User"));
	}
	
	@DataProvider
	public Object[][] getUserTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getUserTestData", description= "Add user data in the form")
	public void validateCreateNewUser(String userRole, String employeeName,String userName, String userStatus, String userPassword, String userConfPassword){
		addUserPage.fillUserFormDetails(userRole, employeeName, userName, userStatus, userPassword, userConfPassword);
	}
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
		log.info("Close the driver");
	}
}
