package com.oht.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.oht.qa.base.TestBase;
import com.oht.qa.pages.ContactPage;
import com.oht.qa.pages.HomePage;
import com.oht.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	
	//to invoke immediate parent class constructor
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public  void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomePageTitle() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Best South Indian Authenticate Sweets, Pickels,Powders.");
	}
	
	@Test(priority=2)
	public void verifyAboutUsLink() {
		homePage.aboutUsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
