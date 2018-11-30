package com.orangehrmselenium.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	
	public AddUserPageTest(){
		super();
	}
	
	@BeforeMethod
	public  void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		adminPage = homePage.clickOnAdminMenu();
		addUserPage = adminPage.clickOnAddButton();
	}
	@Test(priority=1)
	public void VerifyPagDisplayed(){
		Assert.assertTrue(addUserPage.verifyUserPageDisplayed("Add User"));
	}
	
	@DataProvider
	public Object[][] getUserTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getUserTestData")
	public void validateCreateNewUser(String userRole, String employeeName,String userName, String userStatus, String userPassword, String userConfPassword){
		addUserPage.fillUserFormDetails(userRole, employeeName, userName, userStatus, userPassword, userConfPassword);
	}
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
}
