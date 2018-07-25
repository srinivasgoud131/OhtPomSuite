package com.oht.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oht.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(), 'SignIn')]")
	WebElement clickOnSignin;

	@FindBy(name = "userId")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'create')]")
	WebElement creatAccBtn;

	@FindBy(xpath = "//img[contains(@title, 'Native')]")
	WebElement ohtLogo;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement homePageLink;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateohtLogo() {
		return ohtLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		clickOnSignin.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	public RegistrationPage createAccount() {
		creatAccBtn.click();
		
		return new RegistrationPage();
	}
	
	public HomePage clickOnHomePageLink() {
		homePageLink.click();
		
		return new HomePage();
	}
	
	
}