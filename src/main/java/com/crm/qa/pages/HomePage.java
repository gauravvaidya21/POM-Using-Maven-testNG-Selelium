package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory - Object Repositories:
	
			@FindBy(xpath="//span[@class='user-display']")
			WebElement userNameLable;
			
			@FindBy(xpath="//a[@href='/contacts']")
			WebElement contactLink;
			
			@FindBy(xpath="//a[@href='/deals']")
			WebElement dealsLink;
			
			//Initializing the Page Objects:
			public HomePage(){
				PageFactory.initElements(driver, this);
			}
			
			public String verifyHomePageTitle(){
				return driver.getTitle();
			}
			
			public boolean verifyCorrectUserName(){
				return userNameLable.isDisplayed();
			}
			
			public ContactsPage clickOnContactsLink(){
				contactLink.click();
				return new ContactsPage();
			}
			
			public DealsPage clickOnDealsLink(){
				dealsLink.click();
				return new DealsPage();
			}
}
