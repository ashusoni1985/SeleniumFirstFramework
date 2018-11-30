package com.orangehrmselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrmselenium.base.TestBase;

public class AdminPage extends TestBase {
	
	@FindBy(how =How.XPATH, using = "//h1[contains(text(),'System Users')]")
	private WebElement txt_SystemUser;
	@FindBy(how =How.ID, using = "btnAdd")
	private WebElement btn_Add;
	@FindBy(how = How.ID, using= "btnDelete")
	private WebElement btn_Delete;
	@FindBy(how = How.ID, using= "searchBtn")
	private WebElement btn_Search;
	@FindBy(how = How.ID, using= "resetBtn")
	private WebElement btn_Reset;
	
	
	public boolean verifyText(String text){
		if(txt_SystemUser.getText().equals(text)){
			System.out.println("Text message exist");
			return true;
		}else{
			System.out.println("Text message doesn't exist");
			return false;
		}
	}
	
	public AdminPage(){
		PageFactory.initElements(driver, this);
	}
	
	public AddUserPage clickOnAddButton(){
		btn_Add.click();
		return new AddUserPage();
	}

	
}
