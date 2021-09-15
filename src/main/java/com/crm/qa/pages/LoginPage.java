package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - Object Repositories:
	
		@FindBy(linkText="LOG IN")
		WebElement loginBtn;
	
		@FindBy(name="email")
		WebElement email;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(css=".fluid")
		WebElement finalLogin;
		
		@FindBy(linkText="Sign Up")
		WebElement signupBtn;
		
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public HomePage login(String un, String pwd){
			//loginBtn.click();
			
			email.sendKeys(un);
			password.sendKeys(pwd);
			
			return new HomePage();
		}
		
}
