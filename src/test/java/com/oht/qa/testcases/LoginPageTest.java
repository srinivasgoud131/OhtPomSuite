package com.oht.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.oht.qa.base.TestBase;
import com.oht.qa.pages.HomePage;
import com.oht.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	
	//to invoke immediate parent class constructor
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Best South Indian Authenticate Sweets, Pickels,Powders.");
	}
	
	@Test(priority=2)
	public void ohtLogoTest() {
		boolean flag = loginPage.validateohtLogo();
		
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void ohtLoginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void verifyHomePageLinkTest() {
		homePage = loginPage.clickOnHomePageLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}