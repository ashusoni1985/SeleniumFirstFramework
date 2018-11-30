package com.orangehrmselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrmselenium.base.TestBase;

public class AddUserPage extends TestBase {

	@FindBy(how = How.ID, using = "systemUser_userType")
	private WebElement drdnUser_Roles;
	@FindBy(how = How.ID, using = "systemUser_employeeName_empName")
	private WebElement txt_EmpName;
	@FindBy(how = How.ID, using = "systemUser_userName")
	private WebElement txt_userName;
	@FindBy(how = How.ID, using = "systemUser_status")
	private WebElement drdn_Status;
	@FindBy(how = How.ID, using = "systemUser_password")
	private WebElement txt_Password;
	@FindBy(how = How.ID, using = "systemUser_confirmPassword")
	private WebElement txt_confirmPassword;
	@FindBy(how = How.ID, using ="btnSave")
	private WebElement btn_Save;
	@FindBy(how = How.ID, using ="btnCancel")
	private WebElement btn_Cancel;
	@FindBy(how = How.ID, using ="UserHeading")
	private WebElement lbl_UserHeading;
	
	
	public AddUserPage(){
		PageFactory.initElements(driver, this);
	}
	
	public AdminPage clickOnCancelButton(){
		btn_Cancel.click();
		return new AdminPage();
	}
	
	public AdminPage fillUserFormDetails(String role, String empName,String userName, String status, String password, String confPassword){
		
		Select select = new Select(drdnUser_Roles);
		select.selectByVisibleText(role);
		txt_EmpName.sendKeys(empName);
		txt_userName.sendKeys(userName);
		Select statusDropdown = new Select(drdn_Status);
		statusDropdown.selectByVisibleText(status);
		txt_Password.sendKeys(password);
		txt_confirmPassword.sendKeys(confPassword);
		btn_Save.click();
		
		return new AdminPage();
	}
	
	public boolean verifyUserPageDisplayed(String lblUser){
		if(lbl_UserHeading.getText().equals(lblUser)){
			System.out.println("User Navigate to Add User Page");
			return true;
		}else{
			System.out.println("User doesn't Navigate to Add User Page");
			return false;
		}
			
	}
}
