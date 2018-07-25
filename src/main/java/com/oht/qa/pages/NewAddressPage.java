package com.oht.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.oht.qa.base.TestBase;
import com.oht.qa.utils.TestUtil;

public class NewAddressPage extends TestBase {

	@FindBy(css = "em.roundpoint")
	WebElement addToCart;

	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkOut;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement newAddress;

	@FindBy(xpath = "//h4[contains(text(),'SHIPPING')]")
	WebElement addressForm;

	@FindBy(xpath = "//input[contains(@name,'firstName')]")
	WebElement firstname;

	@FindBy(xpath = "//input[contains(@name,'lastName')]")
	WebElement lastname;

	@FindBy(xpath = "//input[contains(@name,'email')]")
	WebElement email;

	@FindBy(xpath = "//input[contains(@name,'mobile')]")
	WebElement phone;

	@FindBy(xpath = "//input[contains(@name,'door')]")
	WebElement doorno;

	@FindBy(xpath = "//input[contains(@name,'street')]")
	WebElement street;

	@FindBy(xpath = "//input[contains(@name,'land')]")
	WebElement landmark;

	@FindBy(xpath = "//input[contains(@name,'city')]")
	WebElement town;

	@FindBy(xpath = "//select[contains(@name,'state')]")
	WebElement state;

	@FindBy(xpath = "//input[contains(@name,'pin')]")
	WebElement pin;

	@FindBy(xpath = "//input[contains(@name,'Home')][1]")
	WebElement homeBtn;

	@FindBy(xpath = "//input[contains(@name,'Home')][2]")
	WebElement officeBtn;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveBtn;

	public NewAddressPage() {
		PageFactory.initElements(driver, this);
	}

	public NewAddressPage openAddressPage() {
		addToCart.click();
		checkOut.click();
		newAddress.click();
		return new NewAddressPage();
	}

	public String addressPage() {
		return addressForm.getText();
	}

	public NewAddressPage typeFirstname(String fname) {
		firstname.sendKeys(fname);
		return this;
	}

	public NewAddressPage typeLastname(String lname) {
		lastname.sendKeys(lname);
		return this;
	}

	public NewAddressPage typeEmail(String mail) {
		email.sendKeys(mail);
		return this;
	}

	public NewAddressPage typeMobile(String mobile) {
		phone.sendKeys(mobile);
		return this;
	}

	public NewAddressPage typeDoorNo(String Dno) {
		doorno.sendKeys(Dno);
		return this;
	}

	public NewAddressPage typeStreetName(String sname) {
		street.sendKeys(sname);
		return this;
	}

	public NewAddressPage typeLandmark(String lmark) {
		landmark.sendKeys(lmark);
		return this;
	}

	public NewAddressPage typeCityname(String city) {
		town.sendKeys(city);
		return this;
	}

	public NewAddressPage selectState(String stname) {
		Select select = new Select(state);
		select.selectByVisibleText(stname);
		return this;
	}

	public NewAddressPage typePinc(String postal) {
		pin.sendKeys(postal);
		return this;
	}

	public NewAddressPage clicOnHomeBtn() {
		homeBtn.click();
		return this;
	}

	public PaymentPage clickOnSaveBtn() {
		saveBtn.click();
		return new PaymentPage();
	}

}