package com.orangehrmselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrmselenium.base.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "txtUsername")
	private WebElement txt_UserName;
	
	@FindBy(how = How.ID, using ="txtPassword")
	private WebElement txt_Password;
	
	@FindBy(how = How.ID, using = "btnLogin")
	private WebElement btn_Login;
	
	@FindBy(how = How.ID, using = "spanMessage")
	private WebElement lbl_ErrorMessgae;
	
	public void enterUserName(String userName){
		txt_UserName.sendKeys(userName);
	}
	public void enterPassword(String password){
		txt_Password.sendKeys(password);
	}
	
	public HomePage clickOnLognButton(){
		btn_Login.click();
		return new HomePage();
	}

	public void login(String userName, String password){
		//enterUserName(userName);
		//enterPassword(password);
		System.out.println("Driver is " + driver);
		txt_UserName.sendKeys(userName);
		txt_Password.sendKeys(password);
		btn_Login.click();
	}
	
	public boolean verifyErrorMessage(String errorMessage){
		if(lbl_ErrorMessgae.getText().equals(errorMessage)){
			System.out.println("Error Message match.");
			return true;
		}
		else{
			System.out.println("Error Message doesn't match");
			return false;
		}
	}
	
	public HomePage loginApplication(String userName, String password){
		txt_UserName.sendKeys(userName);
		txt_Password.sendKeys(password);
		btn_Login.click();
		return new HomePage();
		
	}
	
	public boolean verifyPageTitle(String title){
		String actulTitle = driver.getTitle();
		
		if(actulTitle.equals(title)){
			System.err.println("Page Title Matched");
			return true;
		}
		else{
			System.out.println("Page title doesn't match");
			return false;
		}
	}
}
