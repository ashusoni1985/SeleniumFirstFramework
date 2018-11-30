package com.orangehrmselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrmselenium.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(how = How.ID, using = "welcome")
	private WebElement lbl_Welcome;
	@FindBy(how = How.XPATH, using = "//b[text()='Admin']")
	private WebElement menu_Admin;
	@FindBy(how = How.XPATH, using = "//b[text()='PIM']")
	private WebElement menu_PIM;
	@FindBy(how = How.XPATH, using = "//b[text()='Leave']")
	private WebElement menu_Leave;
	@FindBy(how = How.XPATH, using = "//b[text()='Time']")
	private WebElement menu_Time;
	@FindBy(how = How.XPATH, using = "//b[text()='Recruitment']")
	private WebElement menu_Recruitment;
	@FindBy(how = How.XPATH, using = "//b[text()='Performance']")
	private WebElement menu_Performance;
	@FindBy(how = How.XPATH, using = "//b[text()='Dashboard']")
	private WebElement menu_Dashboard;
	@FindBy(how = How.XPATH, using = "//b[text()='Directory']")
	private WebElement menu_Directory;
	@FindBy(how = How.ID, using = "menu_admin_UserManagement")
	private WebElement menu_AdminUserManagement;
	@FindBy(how = How.ID, using ="menu_admin_viewSystemUsers")
	private WebElement menu_AdminUsers;
	@FindBy(how = How.ID, using = "menu_pim_Configuration")
	private WebElement menu_PIMConfiguraton;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHomePageMessage(String message){
		String homeMessage = lbl_Welcome.getText();
		if(homeMessage.equals(message)){
			System.out.println("Home Page Message Matched");
			return true;
		}
		else{
			System.out.println("Home Page Message doesn't match");
			return false;
		}
	}
	
	public AdminPage clickOnAdminMenu(){
		menu_Admin.click();
		return new AdminPage();
	}
	
	public boolean verifyPageTitle(String exptitle){
		
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(exptitle)){
			System.out.println("Page title verified");
			return true;
		}
		else{
			System.out.println("Page title is not verified");
			return false;
		}
	}
	
	public boolean verifyAdminLinkTest(String menuItem){
		if(menu_Admin.getText().equals(menuItem)){
			System.out.println("Menu Admin Matched");
			return true;
		}
		else{
			System.out.println("Menu Item Admin doesn't match");
			return false;
		}
	}



}
