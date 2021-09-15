package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser


public class HomePageTest extends HomePage{

	public HomePageTest() {
		super();
	}
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	@BeforeMethod
	public void setUp() {
	
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		
		String userNameTitle=(homepage.verifyHomePageTitle());
		Assert.assertEquals(userNameTitle, "Gaurav Vaidya","Home page title not matched");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		
		contactspage = homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
