package com.oht.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.oht.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//a[text()='About Us']")
	WebElement clickOnAboutLink;

	@FindBy(xpath = "//a[contains(text(),'FAQ')]")
	WebElement clickOnFAQLink;

	@FindBy(xpath = "//a[contains(text(),'T&C')]")
	WebElement clickOnTCLink;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement clickOnContactLink;

	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	WebElement clickOnMyAccountLink;

	@FindBy(xpath = "//a[contains(text(),'My Orders')]")
	WebElement clickOnMyOrdersLink;
	
	@FindBy(xpath="//a[contains(text(),'Sign')]")
	WebElement clickOnSignOutLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public AboutUsPage aboutUsLink() {
		clickOnAboutLink.click();
		return new AboutUsPage();
	}
	
	public FAQsPage fAQLink() {
		clickOnFAQLink.click();
		return new FAQsPage();
	}
	
	public TermAndCondPage TermsAndConditionsLink() {
		clickOnTCLink.click();
		return new TermAndCondPage();
	}
	
	public ContactPage contactLink() {
		clickOnContactLink.click();
		return new ContactPage();
	}
	
	public MyAccountPage myAccountLink() {
		clickOnMyAccountLink.click();
		return new MyAccountPage();
	}
	
	public MyOrdersPage myOrdersLink() {
		clickOnMyOrdersLink.click();
		return new MyOrdersPage();
	}
	
	public HomePage signOutLink() {
		clickOnSignOutLink.click();
		return new HomePage();
	}
}